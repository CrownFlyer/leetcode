package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 22:28
 */
public class LEETCODE_844_SIMPLE {

    // 双指针
    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1, tIndex = t.length() - 1;
        int sCnt = 0, tCnt = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while(sIndex>=0){
                if(s.charAt(sIndex)=='#'){
                    sCnt++;
                    sIndex--;
                }else if(sCnt>0){
                    sCnt--;
                    sIndex--;
                }else break;
            }

            while(tIndex>=0){
                if(t.charAt(tIndex)=='#'){
                    tCnt++;
                    tIndex--;
                }else if(tCnt>0){
                    tCnt--;
                    tIndex--;
                }else break;
            }
            if(sIndex>=0 && tIndex>=0){
                if(s.charAt(sIndex)!=t.charAt(tIndex)) return false;
            }else if(sIndex>=0||tIndex>=0) return false;
            sIndex--;
            tIndex--;
        }
        return true;
    }
}
