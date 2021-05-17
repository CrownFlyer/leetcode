package string;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

   @Test
    public void test(){
       String s = "dasdad654f35ds31*3545";
       String p = ".*";
       System.out.println(Pattern.matches(p,s));
   }
}