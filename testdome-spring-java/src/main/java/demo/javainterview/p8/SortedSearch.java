package demo.javainterview.p8;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int l = 0;
        int h = sortedArray.length - 1;

        while (l <= h) {
            int mid = (l + h) >> 1;

            if (sortedArray[mid] < lessThan) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}