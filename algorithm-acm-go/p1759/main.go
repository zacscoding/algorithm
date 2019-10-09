// https://www.acmicpc.net/problem/1759
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	wr = bufio.NewWriter(os.Stdout)
	L  int
	C  int
)

func main() {
	// a t c i s w
	for i := 0; i < 6; i++ {
		var line string
		fmt.Scanln(&line)
		fmt.Println(strconv.Atoi(line))
	}
}
