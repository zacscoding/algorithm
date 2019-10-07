// https://www.acmicpc.net/problem/6603
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	wr     = bufio.NewWriter(os.Stdout)
	k      int
	s      []int
	m      = 6
	picked = make([]int, 6)
)

func main() {
	for {
		fmt.Scan(&k)
		if k == 0 {
			break
		}
		s = make([]int, k)
		for i := 0; i < k; i++ {
			fmt.Scan(&s[i])
		}

		// sort.Sort(sort.Reverse(sort.IntSlice(s)))
		solve(0, 0)
		wr.WriteByte('\n')
	}
	wr.Flush()
}

func solve(idx, selected int) {
	if selected == m {
		for _, v := range picked {
			wr.WriteString(strconv.Itoa(v))
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
		return
	}
	if idx >= k {
		return
	}

	// 1) picked idx
	picked[selected] = s[idx]
	solve(idx+1, selected+1)
	picked[selected] = 0
	solve(idx+1, selected)
}
