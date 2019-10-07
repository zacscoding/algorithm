// https://www.acmicpc.net/problem/10971
package main

import (
	"fmt"
)

var (
	n int
	g [][]int
	a []int
)

func main() {
	fmt.Scan(&n)
	g = make([][]int, n)
	a = make([]int, n+1)

	for i := 0; i < n; i++ {
		g[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scan(&g[i][j])
		}
	}
	for i := 0; i < n; i++ {
		a[i] = i
	}
	a[n] = 0
	sum := calc()
	if sum == -1 {
		sum = 0
	}

	for {
		if !nextPermutation(a, n) {
			break
		}
		a[n] = a[0]
		t := calc()
		if t == -1 {
			continue
		}
		if sum == 0 {
			sum = t
		} else if sum > t {
			sum = t
		}
	}
	fmt.Println(sum)
}

func calc() int {
	sum := 0
	for i := 0; i < len(a)-1; i++ {
		v1 := a[i]
		v2 := a[i+1]
		if g[v1][v2] == 0 {
			return -1
		}
		sum += g[v1][v2]
	}
	return sum
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
