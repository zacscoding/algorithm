package main

import "fmt"

func main() {
	p := []int{6, 9, 5, 7, 4}
	a := solution(p)
	fmt.Println(a)
}

type Pair struct {
	index int
	value int
}

func solution(heights []int) []int {
	answer := make([]int, len(heights))

	var stack1 []Pair
	var stack2 []Pair

	for idx, value := range heights {
		stack1 = append(stack1, Pair{idx, value})
	}

	for {
		if len(stack1) == 0 {
			break
		}

		// pop
		var p Pair
		p, stack1 = stack1[len(stack1)-1], stack1[:len(stack1)-1]
		var r Pair

		for {
			if len(stack1) == 0 {
				break
			}

			var t Pair

			t, stack1 = stack1[len(stack1)-1], stack1[:len(stack1)-1]
			stack2 = append(stack2, t)

			if t.value > p.value {
				r = t
				break
			}
		}

		if len(stack2) != 0 {
			var t Pair
			for i := len(stack2) - 1; i >= 0; i-- {
				t, stack2 = stack2[i], stack2[:i]
				stack1 = append(stack1, t)
			}
		}

		if r == (Pair{}) {
			answer[p.index] = 0
		} else {
			answer[p.index] = r.index + 1
		}

	}

	return answer
}
