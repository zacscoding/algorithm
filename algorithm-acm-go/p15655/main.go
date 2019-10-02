// https://www.acmicpc.net/problem/15655
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
	visit(0, 0)
	wr.Flush()
}

func visit(idx, selected int) {
	if selected == M {
		for i := 0; i < M; i++ {
			wr.WriteString(strconv.Itoa(picked[i]))
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}
	if idx >= N {
		return
	}
	picked[selected] = a[idx]
	visit(idx+1, selected+1)
	picked[selected] = 0
	visit(idx+1, selected)
}
