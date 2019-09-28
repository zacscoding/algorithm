// https://www.acmicpc.net/problem/10817
package main

import (
	"fmt"
	"sort"
)

func main() {
	var a, b, c int
	_, _ = fmt.Scan(&a, &b, &c)
	arr := []int{a, b, c,}
	sort.Ints(arr)
	fmt.Println(arr[1])
}
