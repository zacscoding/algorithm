// https://www.acmicpc.net/problem/11654
package main

import "fmt"

func main() {
	b := make([]byte, 1)
	_, _ = fmt.Scan(&b)
	fmt.Println(int(b[0]))
}
