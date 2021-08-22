package leetcode.easy;

public class RomanToInteger {

    public static int romanToInt(String s) {

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    number += 1000;
                    break;
                case 'D':
                    number += 500;
                    break;
                case 'C':
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'M') {
                            number += 900;
                            i++;
                        }
                        else if (s.charAt(i + 1) == 'D') {
                            number += 400;
                            i++;
                        }
                        else number += 100;
                    } else {
                        number += 100;
                    }
                    break;
                case 'L':
                    number += 50;
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'C') {
                            number += 90;
                            i++;
                        }
                        else if (s.charAt(i + 1) == 'L') {
                            number += 40;
                            i++;
                        }
                        else number += 10;
                    } else {
                        number += 10;
                    }
                    break;
                case 'V':
                    number += 5;
                    break;
                case 'I':
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'X') {
                            number += 9;
                            i++;
                        }
                        else if (s.charAt(i + 1) == 'V') {
                            number += 4;
                            i++;
                        }
                        else number += 1;
                    } else {
                        number += 1;
                    }
                    break;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
