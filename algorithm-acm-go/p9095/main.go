// https://www.acmicpc.net/problem/9095
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	wr = bufio.NewWriter(os.Stdout)
	T  int
	n  int
	dp = make(map[int]int)
)

func main() {
	fmt.Scan(&T)
	dp[0] = 0
	dp[1] = 1
	dp[2] = 2
	dp[3] = 4
	for t := 0; t < T; t++ {
		fmt.Scan(&n)
		wr.WriteString(strconv.Itoa(solve(n)))
		wr.WriteByte('\n')
	}
	wr.Flush()
}

func solve(n int) int {
	if v, ok := dp[n]; ok {
		return v
	}

	dp[n] = solve(n-1) + solve(n-2) + solve(n-3)
	return dp[n]
}
