// https://www.acmicpc.net/problem/11399
package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	_, _ = fmt.Scanf("%d", &n)
	arr := make([]int, n)

	for i := 0; i < n; i++ {
		_, _ = fmt.Scanf("%d", &arr[i])
	}

	sort.Ints(arr)

	seq := 0
	res := 0
	for _, a := range arr {
		seq += a
		res += seq
	}

	fmt.Println(res)
}
