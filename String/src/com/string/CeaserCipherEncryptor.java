package com.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CeaserCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        final String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Arrays.stream(str.split(""))
                .forEach(s -> {
                    sb.append(getEncryptedValue(s, key%26, alphabets));
                });
        return sb.toString();
    }

    public static int titleToNumber(String A) {
        int column = 0;
        final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = A.length() - 1, j = 0; i >= 0; i--, j++ ) {
            column += (alphabets.indexOf(A.charAt(i)) +1) * (int) Math.pow(26, j);
        }
        return column;
    }

    public static String convertToTitle(int A) {
        final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        while(A > 26) {
            int t = A%26;
            sb.append(alphabets.charAt(t == 0 ? 25 : t-1));
            if(t == 0) {
                A = A-26;
            }
            A = A/26;
        }
        if(A <= 26)
            sb.append(alphabets.charAt(A-1));
        return sb.reverse().toString();
    }

    private static char getEncryptedValue(String s, int key, String alphabets) {
        int newKey = alphabets.indexOf(s)+key;
        if(newKey <= 25) {
            return alphabets.charAt(newKey);
        } else {
            newKey = -1+ (newKey%25);
            return alphabets.charAt(newKey);
        }
    }


    public static void main(String[] args) {
        // String result = CeaserCipherEncryptor.caesarCypherEncryptor("abc", 52);
        String result = CeaserCipherEncryptor.convertToTitle(51);
        System.out.println(result);

//        int result1 = CeaserCipherEncryptor.titleToNumber("ZZ");
//        System.out.println(result1);
    }

}
