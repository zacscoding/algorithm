package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	arr := []int{1,2,3,2,1}
	head := &ListNode{Val: arr[0]}
	current := head
	for i:=1; i<len(arr); i++ {
		current.Next = &ListNode{Val: arr[i]}
		current = current.Next
	}
	fmt.Println(isPalindrome(head))
}


func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}

	var rev, temp *ListNode
	fast, slow := head, head
	for {
		if fast == nil || fast.Next == nil {
			break
		}
		fast = fast.Next.Next
		temp = slow.Next
		slow.Next = rev
		rev = slow
		slow = temp
	}
	if fast != nil {
		slow = slow.Next
	}

	for {
		if rev == nil || rev.Val != slow.Val {
			break
		}
		rev, slow = rev.Next, slow.Next
	}
	return rev == nil
}
