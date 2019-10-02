// https://www.acmicpc.net/problem/10972
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	wr = bufio.NewWriter(os.Stdout)
)

func main() {
	var n int
	var a []int
	fmt.Scan(&n)
	a = make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	if nextPermutation(a, n) {
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

func nextPermutation(a []int, n int) bool {
	idx1 := 0
	for i := n - 1; i > 0; i-- {
		if a[i-1] < a[i] {
			idx1 = i
			break
		}
	}
	if idx1 <= 0 {
		return false
	}

	idx2 := n - 1
	for {
		if a[idx2] > a[idx1-1] {
			break
		}
		idx2--
	}
	a[idx1-1], a[idx2] = a[idx2], a[idx1-1]

	j := n - 1
	for {
		if idx1 > j {
			break
		}
		a[idx1], a[j] = a[j], a[idx1]
		idx1++
		j--
	}
	return true
}
