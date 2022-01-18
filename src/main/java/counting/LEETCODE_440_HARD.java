package counting;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-11 21:55
 */
public class LEETCODE_440_HARD {
    public int findKthNumber(int n, int k) {
        // 逐步缩小范围的前缀
        long prefix = 1;
        // 当前已经统计的数量
        long p = 1;
        while(p<k){
            long cnt = helper(n,prefix);
            if(p+cnt > k){
                // 以数字prefix开头的数字串太多，并且第k个数字一定是以数字i开头
                // 此时prefix更新为10*prefix，缩小搜索范围
                prefix *= 10;
                // 位置p向前移动一位，因为新数字prefix字典序向后移动一位了
                p++;
            }else{
                // 以数字prefix开头的数字串不够，将prefix范围缩小，范围从小缩到大
                prefix++;
                p+=cnt;
            }
        }
        return (int)prefix;
    }

    // 不大于n的以prefix开头的数字的个数
    long helper(long n,long prefix){
        long res = 0;
        // 这里统计数量的时候b就很灵性
        // 加入统计n=1003,prefix=10
        // b = 11 -> 第一次统计的为 11 - 10 = 1 是10本身
        // b = 110 -> 第二次统计的为 110 - 100 = 10 是 [100,109] = 10个
        // b = 1100 -> 第三次统计的是 (1003 + 1) - 1000 = 4 是 [1000,10003] = 4个
        for(long a = prefix,b=prefix+1;a<=n;a*=10,b*=10){
            res += Math.min(n+1,b)-a;
        }
        return res;
    }
}
