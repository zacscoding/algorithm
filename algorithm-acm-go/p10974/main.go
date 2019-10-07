// https://www.acmicpc.net/problem/10974
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	wr     = bufio.NewWriter(os.Stdout)
	n      int
	picked []int
	used   []bool
)

func main() {
	fmt.Scan(&n)
	picked = make([]int, n)
	used = make([]bool, n+1)
	solve(0)
	wr.Flush()
}

func solve(idx int) {
	if idx == n {
		for i := 0; i < n; i++ {
			wr.WriteString(strconv.Itoa(picked[i]))
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}

	for i := 1; i <= n; i++ {
		if used[i] {
			continue
		}
		picked[idx] = i
		used[i] = true
		solve(idx + 1)
		used[i] = false
	}
}
