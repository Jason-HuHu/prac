package com.huxl.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author huxl
 * @since 2019/12/30-16:11
 */
public class WordTest {

    public static void main(String[] args) {
        String patternString = "[a-z]*ab";
        String input = "cab";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            input = scanner.next();
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println(matcher.toString());
            }else
                System.out.println("未匹配");
        }

    }
}
