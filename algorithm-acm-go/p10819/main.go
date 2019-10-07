// https://www.acmicpc.net/problem/10819
package main

import (
	"fmt"
	"sort"
)

var (
	n int
	a []int
)

func main() {
	fmt.Scan(&n)
	a = make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}
	sort.Ints(a)
	max := calc(a, n)
	for {
		if !nextPermutation(a, n) {
			break
		}
		sum := calc(a, n)
		if sum > max {
			max = sum
		}
	}
	fmt.Println(max)
}

func calc(a []int, n int) int {
	sum := 0
	for i := 0; i <= n-2; i++ {
		t := a[i] - a[i+1]
		if t < 0 {
			t *= -1
		}
		sum += t
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
