package com.huxl.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author huxl
 * @since 2020/1/9-9:29
 */
public class RegexTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pattern:");
        String patternString = scanner.nextLine();

        Pattern pattern = Pattern.compile(patternString);
        while (true) {

            System.out.println("Enter string to match:");
            String input = scanner.nextLine();
            if (input == null || input.equals("")) {
                return;
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Match");
                int g = matcher.groupCount();
                if (g > 0) {
                    for (int i= 0; i < input.length(); i++) {
                        //Print any empty groups
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i == matcher.end(j)) {
                                System.out.println("()");
                            }
                        }
                    }

                }
            }
        }
    }
}
