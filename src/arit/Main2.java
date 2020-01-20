package arit;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        final String a = "ab";
        String b = "ab";
        String c = "abc";
        String d = a+"c";
        String e = b+"c";
        System.out.println((d==c)+","+(e==c));
    }
}
