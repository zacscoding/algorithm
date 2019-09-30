// https://www.acmicpc.net/problem/10952
package main

import "fmt"

func main() {
	for {
		var a, b uint8
		_, _ = fmt.Scan(&a, &b)
		if a == 0 && b == 0 {
			break
		}
		fmt.Println(a + b)
	}
}
