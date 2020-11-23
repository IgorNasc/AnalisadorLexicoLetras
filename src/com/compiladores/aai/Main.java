package com.compiladores.aai;

/****************************************************************************************************
 * Universidade FUMEC             									                                *
 * Compiladores                                                                                     *
 * Analisador lexico para identificar a seguinte expressao                                          *
 * letter_ -> A | B | ... | Z | a | b | ... | z | _                                                 *
 * digit -> 0 | 1 | ... | 9                                                                         *
 * id -> letter_(letter_ | digit)*                                                                  *
 ****************************************************************************************************/
public class Main {
    public static String letters = "abcdefghijklmnopqrstuvxzwy_";
    public static String numbers = "0123456789";

    private static boolean isLetter(char letter) {
        return letters.contains(String.valueOf(letter).toLowerCase());
    }

    private static boolean isNumber(char number) {
        return numbers.contains(String.valueOf(number).toLowerCase());
    }

    private static boolean isValid(char text) {
        return isLetter(text) || isNumber(text);
    }

    public static void main(String[] args) {
        String text = "_abcd_1234.";
	    int state = 1;

	    while (state != 3 && state != -1) {
            switch (state) {
                case 1:
                    if (isLetter(text.toCharArray()[0])) state = 2;
                    else state = -1;
                    break;
                case 2:
                    state = 3;
                    for (char ch: text.toCharArray()){
                        if (!isValid(ch)) state = -1;
                    }
                    break;
            }
        }

	    if (state == -1) {
	        System.out.println("Serie de characteres inválido!");
        }
	    else if (state == 3) {
	        System.out.println("Serie de characteres válido!");
        }
    }
}
