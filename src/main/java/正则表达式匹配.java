public class 正则表达式匹配 {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, pattern, 0, 0);
    }

    public boolean match(char[] str, char[] pattern, int s, int p) {
        // 匹配到末尾，匹配成功
        if (s == str.length && p == pattern.length) {
            return true;
        }
        // pattern先到最后，匹配失败
        if (p == pattern.length) {
            return false;
        }
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            // 匹配上了
            if (s != str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                return match(str, pattern, s , p + 2) || match(str, pattern, s + 1, p);
            }
            // 匹配不上，x*当做零匹配
            return match(str, pattern, s, p + 2);
        } else {  //pattern到最后了，必须正好匹配上
            if (s != str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                return match(str, pattern, s + 1, p + 1);
            }
            return false;
        }
    }
}