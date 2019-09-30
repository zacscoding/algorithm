// https://www.acmicpc.net/problem/15654
package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

var (
	wr     = bufio.NewWriter(os.Stdout)
	N, M   int
	a      []int
	used   []bool
	picked []int
)

func main() {
	fmt.Scanf("%d %d", &N, &M)
	a = make([]int, N)
	used = make([]bool, N)
	picked = make([]int, M)
	for i := 0; i < N; i++ {
		fmt.Scanf("%d", &a[i])
	}
	sort.Ints(a)
	solve(0)
	wr.Flush()
}

func solve(idx int) {
	if idx == M {
		for i := 0; i < M; i++ {
			wr.WriteString(fmt.Sprintf("%d", picked[i]))
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}

	for i := 0; i < N; i++ {
		if used[i] {
			continue
		}
		used[i] = true
		picked[idx] = a[i]
		solve(idx + 1)
		used[i] = false
	}
}
