package main

import "fmt"

func main() {
	fmt.Println(pivotIndex([]int{1, 7, 3, 6, 5, 6}))
}

func pivotIndex(nums []int) int {
	if len(nums) < 3 {
		return -1
	}

	var (
		total   = 0
		leftSum = 0
	)
	for _, num := range nums {
		total += num
	}

	for i, num := range nums {
		if leftSum == total-leftSum-num {
			return i
		}
		leftSum += num
	}
	return -1
}
