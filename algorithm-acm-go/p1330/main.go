// https://www.acmicpc.net/problem/1330
package main

import "fmt"

func main() {
	var n1, n2 int
	_, _ = fmt.Scanf("%d%d", &n1, &n2)
	if n1 > n2 {
		fmt.Println(">")
	} else if n1 < n2 {
		fmt.Println("<")
	} else {
		fmt.Println("==")
	}
}
