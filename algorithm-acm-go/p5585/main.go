// https://www.acmicpc.net/problem/5585
package main

import "fmt"

var (
	n int
)

func main() {
	_, _ = fmt.Scanf("%d", &n)
	r := 1000 - n
	cs := []int{500, 100, 50, 10, 5}
	count := 0
	for _, c := range cs {
		if c > r {
			continue
		}

		t := r / c
		count += t
		r -= c * t

		if r == 0 {
			break
		}
	}

	count += r
	fmt.Println(count)
}
