import java.util.stream.Stream;

/**
 * 将一个字符串中的空格替换成 "%20"。
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        int p1 = 0;
        int len = str.length();
        for (; p1 < len; p1++) {
            if (str.charAt(p1) == ' ') {
                str.append("**");
            }
        }
        p1--;
        int p2 = str.length() - 1;
        while (p1 >= 0) {
            if (str.charAt(p1) == ' ') {
                str.replace(p2-2, p2+1, "%20");
                p2 -= 3;
            }else{
                str.setCharAt(p2, str.charAt(p1));
                p2--;
            }
            p1--;
        }
        return str.toString();
    }
}
