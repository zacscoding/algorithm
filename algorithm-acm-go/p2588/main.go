// https://www.acmicpc.net/problem/2588
package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	var n1 int
	var n2 string
	_, _ = fmt.Scanf("%d\n%s", &n1, &n2)
	s := strings.Split(n2, "")
	s2, _ := strconv.Atoi(s[2])
	s1, _ := strconv.Atoi(s[1])
	s0, _ := strconv.Atoi(s[0])

	v1 := n1 * s2
	v2 := n1 * s1
	v3 := n1 * s0
	v4 := v1 + (v2 * 10) + (v3 * 100)
	fmt.Println(v1)
	fmt.Println(v2)
	fmt.Println(v3)
	fmt.Println(v4)
}
