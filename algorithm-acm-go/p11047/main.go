// https://www.acmicpc.net/problem/11047
package main

import "fmt"

var (
	n, k int
	a    []int
)

func main() {
	_, _ = fmt.Scanf("%d %d", &n, &k)

	a = make([]int, n)

	for i := 0; i < n; i++ {
		_, _ = fmt.Scanf("%d", &a[i])
	}

	total := 0
	remain := k

	for i := n - 1; i >= 0; i-- {
		u, r := solve(i, remain)

		if u == 0 {
			continue
		}

		total += u
		remain = r

		if remain == 0 {
			break
		}
	}
	fmt.Println(total)
}

func solve(idx, remain int) (int, int) {
	if remain < a[idx] {
		return 0, remain
	}

	usedCoin := remain / a[idx]
	remain -= a[idx] * usedCoin

	return usedCoin, remain
}
