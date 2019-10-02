// https://www.acmicpc.net/problem/15656
package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

var (
	wr     = bufio.NewWriter(os.Stdout)
	N, M   int
	a      []int
	picked []int
)

func main() {
	fmt.Scanf("%d %d", &N, &M)
	a = make([]int, N)
	picked = make([]int, M)
	for i := 0; i < N; i++ {
		fmt.Scan(&a[i])
	}
	sort.Ints(a)
	solve(0)
	wr.Flush()
}

func solve(idx int) {
	if idx == M {
		for i := 0; i < M; i++ {
			wr.WriteString(strconv.Itoa(picked[i]))
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}
	for i := 0; i < N; i++ {
		picked[idx] = a[i]
		solve(idx + 1)
	}
}
