package com.batchmates.android.test5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 7/21/2017.
 */

public class TestFiveCodingTest {

    public static void main(String[] args) {

        parenthesisCheck("[][]{}[{}]()");

        hasStringInside("catcowcat", "cow", 1);


    }


    public static void hasStringInside(String orig, String sub, int times) {
        int counter = 0;
        boolean hasIt = true;
        for (int i = 0; i < orig.length(); i++) {
            if (orig.charAt(i) == sub.charAt(0) && orig.length() - i >= sub.length()) {

                for (int j = 0; j < sub.length(); j++) {
                    if (orig.charAt(i + j) != sub.charAt(j)) {
                        hasIt = false;
                    }

                }
                if (hasIt == true) {
//                    System.out.println(""+ i);
                    counter++;
                } else {
                    hasIt = true;
                }
            }

        }

        if (counter == times) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


    public static void parenthesisCheck(String s) {
        String checkPar2 = ")";
        String checkPar = "(";
        String checkBrack = "[";
        String checkBrack2 = "]";
        String checkOther = "{";
        String checkOther2 = "}";
        boolean isTruePar = true;
        int parCounter = 0;
        boolean isTrueBrack = true;
        int brackCounter = 0;
        boolean isTrueOther = true;
        int otherCounter = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == checkPar.charAt(0)) {
                parCounter++;
                list.add("(");
                System.out.println(list);
            }
            if (s.charAt(i) == checkPar2.charAt(0)) {
                if (list.get(list.size() - 1) == "(") {
                    parCounter--;
                    list.remove(list.size() - 1);

                }
            }

            if (s.charAt(i) == checkBrack.charAt(0)) {
                brackCounter++;
                list.add("[");
                System.out.println(list);
            }
            if (s.charAt(i) == checkBrack2.charAt(0)) {
                if (list.get(list.size() - 1) == "[") {
                    brackCounter--;
                    list.remove(list.size() - 1);
                }
            }


            if (s.charAt(i) == checkOther.charAt(0)) {
                brackCounter++;
                list.add("{");
                System.out.println(list);
            }
            if (s.charAt(i) == checkOther2.charAt(0)) {
                if (list.get(list.size() - 1) == "{") {
                    brackCounter--;
                    list.remove(list.size() - 1);
                }
            }


        }
        if (brackCounter != 0 || otherCounter != 0 || parCounter != 0) {
            System.out.println("false" + " counters: " + parCounter + " " + brackCounter + " " + otherCounter);
        } else {
            System.out.println("true");
        }
    }
}