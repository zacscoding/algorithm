// https://www.acmicpc.net/problem/2884
package main

import "fmt"

func main() {
	var h, m int
	_, _ = fmt.Scan(&h, &m)
	tm := h*60 + m
	tm -= 45
	if tm < 0 {
		tm += 60 * 24
	}
	h = tm / 60
	m = tm % 60
	fmt.Println(h, m)
}
