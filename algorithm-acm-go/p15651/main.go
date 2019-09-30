// https://www.acmicpc.net/problem/15651
package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	wr   = bufio.NewWriter(os.Stdout)
	N, M int
	a    = make([]int, 10)
)

func main() {
	fmt.Scanf("%d %d", &N, &M)
	solve(0)
	wr.Flush()
}

func solve(idx int) {
	if idx == M {
		for i := 0; i < M; i++ {
			wr.WriteByte(byte(a[i]) + '0')
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}

	for i := 1; i <= N; i++ {
		a[idx] = i
		solve(idx + 1)
	}
}
