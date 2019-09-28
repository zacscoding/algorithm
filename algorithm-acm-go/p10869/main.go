// https://www.acmicpc.net/problem/10869
package main

import "fmt"

func main() {
	var n1, n2 int
	_, _ = fmt.Scanf("%d%d", &n1, &n2)
	fmt.Println(n1 + n2)
	fmt.Println(n1 - n2)
	fmt.Println(n1 * n2)
	fmt.Println(n1 / n2)
	fmt.Println(n1 % n2)
}
