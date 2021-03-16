package com.github.offer;

public class CodeDanceTesting {

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>w
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    private static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 0;
        char temp;
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i - 1 < max) {
                break;
            }
            sub.delete(0, sub.length());
            for (int j = i; j < s.length(); j++) {
                if (sub.toString().indexOf((temp = s.charAt(j))) == -1) {
                    sub.append(temp);
                } else {
                    break;
                }

            }
            max = Math.max(max, sub.length());
        }
        return max;
        /**
         * 提交记录
         * 987 / 987 个通过测试用例
         * 状态：通过
         * 执行用时: 258 ms
         * 内存消耗: 39 MB
         * 提交时间：几秒前
         */
    }

}
