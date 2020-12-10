package lessons.arr;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(
                new OddOccurrencesInArray().solution(new int[] { 9, 3, 9, 3, 9, 7, 9 })
        );
    }

    public int solution(int[] A) {
        int ret = 0;
        for (int a : A) {
            ret ^= a;
        }
        return ret;
    }
}
