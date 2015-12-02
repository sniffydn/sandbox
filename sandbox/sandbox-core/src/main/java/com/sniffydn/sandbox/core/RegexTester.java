/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sniffydn.sandbox.core;

import java.util.regex.Pattern;

/**
 *
 * @author dnyffeler
 */
public class RegexTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s =  "KFTXXJIKADTEOBGF20151027135301-boiseSt-template1";
        String s1 = "FTXXJIKADTEOBGF20151027135301-boiseSt-template1";
        String s2 = "1FTXXJIKADTEOBGF20151027135301-boiseSt-template1";
        String s3 = "KFTXXJIKADTEOBGFG0151027135301-boiseSt-template1";
        String s4 = "KFTXXJIKADTEOBGF20151027135301-template1";
        
        String regex = "[A-Z]{16}\\d{14}-\\w{1,}-\\w{1,}";//16 capital characters A-Z, 14 digits for the date/time, -, a campaign name so 1 or more word characters, -,  a template name so 1 or more word characters
//        String regex = "KFTXXJIKADTEOBGF20151027135301-boiseSt-template1";
        
        System.out.println(Pattern.matches(regex, s));
        System.out.println(Pattern.matches(regex, s1));
        System.out.println(Pattern.matches(regex, s2));
        System.out.println(Pattern.matches(regex, s3));
        System.out.println(Pattern.matches(regex, s4));
    }
    
}
