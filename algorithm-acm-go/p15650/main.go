// https://www.acmicpc.net/problem/15650
package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	wr   = bufio.NewWriter(os.Stdout)
	N, M int
	used = make([]bool, 10)
	a    = make([]int, 10)
)

func main() {
	_, _ = fmt.Scanf("%d %d", &N, &M)
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

	var start int
	if idx == 0 {
		start = 1
	} else {
		start = a[idx-1] + 1
	}
	for i := start; i <= N; i++ {
		if used[i] {
			continue
		}
		used[i] = true
		a[idx] = i
		solve(idx + 1)
		used[i] = false
	}
}
