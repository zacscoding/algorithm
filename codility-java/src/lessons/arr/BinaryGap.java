package lessons.arr;

public class BinaryGap {
    public int solution(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int len = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                max = Math.max(max, len);
                len = 0;
            } else {
                len++;
            }
        }
        return max;
    }
}
