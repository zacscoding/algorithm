package main

import (
	"sort"
)

func twoSum_map(nums []int, target int) []int {
	m := make(map[int]int)
	for i, num := range nums {
		if idx, ok := m[target-num]; ok {
			return []int{i, idx}
		}
		m[num] = i
	}
	return []int{}
}

func twoSum_twopoint(nums []int, target int) []int {
	type pair struct {
		idx   int
		value int
	}
	pairs := make([]pair, len(nums))
	for i, num := range nums {
		pairs[i] = pair{
			idx:   i,
			value: num,
		}
	}
	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].value-pairs[j].value < 0
	})

	left := 0
	right := len(nums) - 1
	for {
		if left == right {
			break
		}
		sum := pairs[left].value + pairs[right].value
		if sum == target {
			return []int{pairs[left].idx, pairs[right].idx}
		} else if sum < target {
			left++
		} else {
			right--
		}

	}
	return []int{}
}
