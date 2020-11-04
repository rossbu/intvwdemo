package com.shareforever.intvwdemo.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*
    https://stackoverflow.com/questions/58046693/biconsumer-and-method-reference-of-one-parameter
 */
public class BiConsumerExp {
    private String name;

    public BiConsumerExp(String name) {
        this.name = name;
    }

    public void oneParamMethod(Object o) {
        System.out.println(this.name + " and " + o);
    }

    public <T, S> void executeBiConsumer(BiConsumer<T, S> biCon, T in1, S in2) {
        biCon.accept(in1, in2);
    }

    public static void main(String[] args) {

        // Simple biconsumer example
        Map<String, Integer> map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> biConsumer = (e1, e2) -> System.out.println(e1 + ": " + e2);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }

        // hard biconsumer example
        BiConsumerExp exp = new BiConsumerExp("INSTANCE"); // it won't be printed out
        // executeBiConsumer expects a functional of two params but is given a method reference of one param. HOW IS THIS LEGAL?
        // exp.executeBiConsumer(BiConsumerExp::oneParamMethod, new String("INVALID"), 999);// won't compile
        exp.executeBiConsumer(BiConsumerExp::oneParamMethod, new BiConsumerExp("PARAM"), 999);
        BiConsumer<BiConsumerExp, Integer> biCon = (first, second) -> first.oneParamMethod(second);
        biCon.accept(new BiConsumerExp("PARAM"), 999);
//      A method reference referencing an instance method having one argument actually has two arguments - the first argument is implicit - the instance on which the method is executed
//      Experiment::oneParamMethod is equivalent to (Experiment e, Object o) -> e.oneParamMethod(o).

    }
}
