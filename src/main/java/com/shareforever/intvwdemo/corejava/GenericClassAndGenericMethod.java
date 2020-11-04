package com.shareforever.intvwdemo.corejava;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/methods.html
 * The type parameter section, delimited by angle brackets (<>), follows the class name.
 * It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.
 * <p>
 * Generic Type
 * className<T1,T2...TN>
 * <p>
 * Generic Method
 * <T1,T2...Tn> boolean isRight(T1 t, T2 t2)
 * when use it.  put before method name: GenericClassAndGenericMethod.<String,String>compare(null,null)
 * <p>
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 */
public class GenericClassAndGenericMethod<K, V> {

    /*
     The syntax for a generic method includes a list of type parameters, inside angle brackets <>,
        which appears before the method's return type.
     */
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    static class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static class TestSelf {
        public static void main(String[] args) {
            Pair<Integer, String> p1 = new Pair<>(1, "apple");
            Pair<Integer, String> p2 = new Pair<>(2, "pear");
            boolean same = GenericClassAndGenericMethod.<Integer, String>compare(p1, p2);
            System.out.println(same);
            GenericClassAndGenericMethod.<String, String>compare(null, null); // you can't use <String,String>compare directly.
        }
    }
}
