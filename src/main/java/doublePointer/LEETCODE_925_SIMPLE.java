package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 08:29
 */
public class LEETCODE_925_SIMPLE {
    public boolean isLongPressedName(String name, String typed) {
        char cur;
        int cnt = 0;
        // 指向name
        int l = 0;
        // 指向typed
        int r = 0;
        int nameLen = name.length();
        int typeLen = typed.length();
        while (l < nameLen) {
            cur = name.charAt(l);
            while (l < nameLen && name.charAt(l++) == cur) cnt++;
            while (r < typeLen && typed.charAt(r++) == cur) cnt--;
            if (cnt > 0) return false;
            cnt = 0;
        }
        return true;
    }

}
