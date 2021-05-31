package exer.leetcode.week243;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section1 {
    public static void main(String[] args) {
        Section1 test = new Section1();
        String s1 = "aaa";
        String s2 = "a";
        String s3 = "aaaa";
        System.out.println(test.isSumEqual(s1, s2, s3));
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int len1 = firstWord.length();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < len1; i++) {
            sb1.append(firstWord.charAt(i)-'a');
        }
        int num1 = Integer.parseInt(sb1.toString());

        int len2 = secondWord.length();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < len2; i++) {
            sb2.append(secondWord.charAt(i)-'a');
        }
        int num2 = Integer.parseInt(sb2.toString());

        int len3 = targetWord.length();
        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < len3; i++) {
            sb3.append(targetWord.charAt(i)-'a');
        }
        int num3 = Integer.parseInt(sb3.toString());
        return (num1+num2)==num3;

    }





}
