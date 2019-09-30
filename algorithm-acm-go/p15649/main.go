// https://www.acmicpc.net/problem/15649
package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	wr = bufio.NewWriter(os.Stdout)
	c  = make([]bool, 10)
	a  = make([]int, 10)
)

func main() {
	var n, m int
	_, _ = fmt.Scanf("%d %d", &n, &m)
	solve(0, n, m)
	wr.Flush()
}

func solve(idx, n, m int) {
	if idx == m {
		for i := 0; i < m; i++ {
			wr.WriteByte(byte(a[i]) + '0')
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}
	for i := 1; i <= n; i++ {
		if c[i] {
			continue
		}
		c[i] = true
		a[idx] = i
		solve(idx+1, n, m)
		c[i] = false
	}
}
