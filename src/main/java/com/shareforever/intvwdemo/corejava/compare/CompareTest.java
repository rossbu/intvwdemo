package com.shareforever.intvwdemo.corejava.compare;

import com.shareforever.intvwdemo.pojo.Movie;
import com.shareforever.intvwdemo.pojo.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareTest {


    /*
                implements comparator
                public int compare(Student s1, Student s2) { return -1 or 1 or 0 }

                implements comparable
                public int compareTo(Student s1){  return -1 or 1 or 0 }

     */
    public static void main(String[] args) {

        comparableTest();
        comparatorTest();
    }

    private static void comparableTest() {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));


        // compare by nature order defined in Movie class
        Collections.sort(list);
        System.out.println("Movies after sorting by comparable natural order : ");
        for (Movie movie: list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
        System.out.println("\n");

        // Collections(list, comparator)
        Collections.sort(list, (m1, m2) -> Double.valueOf(m2.getRating()).compareTo(Double.valueOf(m1.getRating())));
        System.out.println("Movies after sorting by comparator rating : ");
        for (Movie movie: list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
    }

    private static void comparatorTest() {
        // lambda comparator
        Comparator<Student> comparator1 = (s1 , s2) -> s1.getId() - s2.getId();

        // legacy comparator
        Comparator<Student> comparator2 = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getId() - s2.getId();
            }
        } ;
    }
}
