package chap20.suffixarray.prob3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static char[] chArr;
	public static int[][] cache;

	public static void main(String[] args) throws Exception {
		/* input */
		Scanner sc = new Scanner(System.in);
		chArr = sc.next().toCharArray();
		cache = new int[chArr.length][];
		for (int i = 0; i < chArr.length; i++) {
			cache[i] = new int[chArr.length];
		}

		/* outupt */
		Integer[] suffix = new Integer[chArr.length];
		for (int i = 0; i < suffix.length; i++) {
			suffix[i] = i;
		}

		Arrays.sort(suffix, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (cache[o1][o2] != 0) {
					int sameLen = cache[o1][o2];
					if (sameLen == -1)
						sameLen = 0;
					return chArr[o1 + sameLen] - chArr[o2 + sameLen];
				}

				int len = (o1 > o2) ? chArr.length - o1 : chArr.length - o2;
				int result = 0;
				int ret = 0;
				for (int i = 0; i < len; i++) {
					if (chArr[o1 + i] == chArr[o2 + i]) {
						result++;
					} else {
						ret = chArr[o1 + i] - chArr[o2 + i];
						break;
					}
				}
				int cacheVal = (result == 0) ? -1 : result;
				cache[o1][o2] = cacheVal;
				cache[o2][o1] = cacheVal;
				if (ret == 0)
					ret = (o1 > o2) ? -1 : 1;
				return ret;
			}
		});

		for (int i = 0; i < suffix.length; i++)
			System.out.print((suffix[i] + 1) + " ");
		System.out.print("\nx ");
		for (int i = 0; i < suffix.length - 1; i++) {
			int val = cache[suffix[i]][suffix[i + 1]];
			if (val == 0) {
				val = countSame(suffix[i], suffix[i + 1]);
			} else if (val == -1) {
				val = 0;
			}
			System.out.print(val + " ");
		}
	}

	public static int countSame(int i, int j) {
		int len = i > j ? chArr.length - i : chArr.length - j;
		int ret = 0;
		for (int k = 0; k < len; k++) {
			if (chArr[i + k] == chArr[j + k])
				ret++;
			else
				break;
		}
		return ret;
	}
}
