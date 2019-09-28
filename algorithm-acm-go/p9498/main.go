// https://www.acmicpc.net/problem/9498
package main

import "fmt"

func main() {
	var n int
	_, _ = fmt.Scan(&n)
	n /= 10
	switch n {
	case 10:
		fmt.Println("A")
	case 9:
		fmt.Println("A")
	case 8:
		fmt.Println("B")
	case 7:
		fmt.Println("C")
	case 6:
		fmt.Println("D")
	default:
		fmt.Println("F")
	}
}
