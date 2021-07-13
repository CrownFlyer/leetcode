package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-10 14:48
 */
public class LEETCODE_1055_MIDDLE {
    // dp
    public int shortestWay1(String source, String target) {
        int n = target.length();
        if(n==0) return 0;
        Set<Character> set = new HashSet<>();
        char[] char_source = source.toCharArray();
        for(char c:char_source) set.add(c);
        // dp[i]:前i+1个元素组成的子字符串最少需要source个数
        int[] dp = new int[n];


        char[] char_target = target.toCharArray();
        // 以target[i] 结尾的最长子序
        String[] sub = new String[n];

        for(int i=0;i<n;i++) if(!set.contains(char_target[i])) return -1;
        dp[0] = 1;
        sub[0] = char_target[0] + "";

        for(int i=1;i<n;i++){
            String tailSubString = sub[i-1] + char_target[i];
            if(isSubString(char_source,tailSubString.toCharArray())){
                dp[i] = dp[i-1];
                sub[i] = tailSubString;
            }else{
                dp[i] = dp[i-1] + 1;
                sub[i] = char_target[i]+"";
            }
        }
        return dp[n-1];
    }

    public boolean isSubString(char[] src,char[] test){
        if(test.length>src.length) return false;

        int indexSrc = 0, indexTest =0;
        int lenSrc = src.length, lenTest = test.length;
        while(indexSrc<lenSrc&&indexTest<lenTest){
            if(src[indexSrc]==test[indexTest]) indexTest++;
            indexSrc++;
        }
        return indexTest == lenTest;
    }

    // 贪心
    public int shortestWay(String source, String target) {
        int sLen = source.length();
        int tLen = target.length();

        if(tLen==0) return 0;
        if(sLen==0) return -1;

        int cnt = 0;
        int tid = 0;
        while (true) {
            cnt++;
            int last_tid = tid;
            for (int i = 0; i < sLen; i++) {
                if(source.charAt(i)==target.charAt(tid)) tid++;
                if(tid==tLen) return cnt;
            }
            if(last_tid==tid) return -1;
        }
    }
}
