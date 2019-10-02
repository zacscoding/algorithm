// https://www.acmicpc.net/problem/10973
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	wr = bufio.NewWriter(os.Stdout)
	n  int
	a  []int
)

func main() {
	fmt.Scan(&n)
	a = make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	if solve() {
		for i := 0; i < n; i++ {
			wr.WriteString(strconv.Itoa(a[i]))
			wr.WriteByte(' ')
		}
		wr.WriteByte('\n')
	} else {
		wr.WriteString(strconv.Itoa(-1))
	}
	wr.Flush()
}

func solve() bool {
	idx1 := 0
	for i := n - 1; i > 0; i-- {
		if a[i] < a[i-1] {
			idx1 = i
			break
		}
	}
	if idx1 == 0 {
		return false
	}
	var idx2 int
	t := 0
	for i := idx1; i < n; i++ {
		if a[idx1-1] > a[i] && a[i] > t {
			idx2 = i
		}
	}
	a[idx1-1], a[idx2] = a[idx2], a[idx1-1]
	i := idx1
	j := n - 1
	for {
		if i >= j {
			break
		}
		a[i], a[j] = a[j], a[i]
		i++
		j--
	}
	return true
}
