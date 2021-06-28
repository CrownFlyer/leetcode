package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-25 19:30
 */
public class LEETCODE_22_MIDDLE {
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,new StringBuilder(),0,0,n);
        return res;
    }

    public void backtrack(List<String> res,StringBuilder sb,int open,int close,int max){
        if(sb.length() == max*2){
            res.add(sb.toString());
            return;
        }

        if(open<max){
            sb.append('(');
            backtrack(res,sb,open+1,close,max);
            sb.deleteCharAt(open+close);
        }
        if(close<open){
            sb.append(')');
            backtrack(res,sb,open,close+1,max);
            sb.deleteCharAt(open+close);
        }
    }
}
