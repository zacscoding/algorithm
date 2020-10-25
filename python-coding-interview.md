# 파이썬 코딩 인터뷰
파이썬 코딩 인터뷰 책 정리  


- [3.선형 자료구조](#3-선형-자료구조)  
  - [3.1 배열](#31-배열)
    - [두 수의 합](#두-수의-합)
  - [3.2 연결 리스트](#32-연결-리스트)  
    - [두 수의 합](#두-수의-합)
  - [3.3 스택,큐](#33-스택-큐)  
    - [유효한 괄호](#유효한-괄호)
    - [큐를 이용한 스택 구현](#큐를-이용한-스택-구현)

---  

# 3. 선형 자료구조

## 3.1 배열  

### 두 수의 합  

https://leetcode.com/problems/two-sum/  

**Problem**  

덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴

- 입력  

```
nums = [2,7,11,15], target = 9
```  

- 출력  

```
[0,1]
```  

**Solution**  

1. 브루트 포스로 계산

```java
// brute force
public int[] twoSum_bruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] { i, j };
            }
        }
    }
    throw new RuntimeException("unreachable code");
}
```  

2. map 이용  
맵의 키를 `value`, 값을 배열의 `index`로 설정  

```java
public int[] twoSum_map(int[] nums, int target) {
  Map<Integer, Integer> map = new HashMap<>();

  for(int i=0; i<nums.length; i++) {
      Integer idx = map.get(target - nums[i]);
      if (idx != null) {
          return new int[] { i, idx };
      }
      map.put(nums[i], i);
  }

  throw new RuntimeException("unreachable code");
}
```  

3. two point 이용
문제는 `index`를 반환해야 하므로 별도로 정렬 후 별도의 `index`와 `value`를 유지한다.  

```java
public int[] twoSum_twoPoint(int[] nums, int target) {
    Pair[] pairs = new Pair[nums.length];
    for (int i = 0; i < nums.length; i++) {
        pairs[i] = new Pair(i, nums[i]);
    }
    Arrays.sort(pairs, Comparator.comparingInt(p -> p.value));
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
        int sum = pairs[left].value + pairs[right].value;
        if (sum == target) {
            return new int[] { pairs[left].idx, pairs[right].idx };
        } else if (sum < target) {
            left += 1;
        } else {
            right -= 1;
        }
    }
    throw new RuntimeException("unreachable code");
}

public static class Pair {
    int idx;
    int value;

    public Pair(int l, int r) {
        this.idx = l;
        this.value = r;
    }
}
```


---  

## 3.2 연결 리스트  

### 팰린드롬 연결 리스트

https://leetcode.com/problems/two-sum/  

**Problem**  

연결 리스트가 팰린드롬 구조인지 판별  

> e.g1

- 입력  

```
1->2
```  

- 출력  

```
false
```  

> e.g2

- 입력  

```
1->2->2->1
```  

- 출력  

```
true
```  


**Solution**   

1. Deque를 이용하여 풀이  

```java
public boolean isPalindrome_Deque(ListNode head) {
    if (head == null) {
        return true;
    }
    Deque<Integer> que = new LinkedList<>();
    ListNode cur = head;
    while (cur != null) {
        que.addLast(cur.val);
        cur = cur.next;
    }

    while (que.size() > 1) {
        if (!que.pollFirst().equals(que.pollLast())) {
            return false;
        }
    }
    return true;
}
```  

2. Runner를 이용  
- slow(1칸), fast(2칸)을 이동하는 포인터 및 reverse list 정의
- 홀수 일 경우 slow를 한칸 더 이동(중앙값은 제외되므로)  
- reverse list와 중앙에 위치한 slow가 가리키는 리스트를 비교  

```java
public boolean isPalindrome_Runner(ListNode head) {
    if (head == null) {
        return true;
    }

    ListNode fast = head, slow = head, rev = null;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        ListNode temp = slow.next;
        slow.next = rev;
        rev = slow;
        slow = temp;
    }
    if (fast != null) {
        slow = slow.next;
    }

    while (rev != null) {
        if (rev.val != slow.val) {
            return false;
        }
        rev = rev.next;
        slow = slow.next;
    }
    return true;
}
```

---  

## 3.3 스택 큐


### 유효한 괄호  

https://leetcode.com/problems/valid-parentheses/  


**Problem**  

괄호로 된 입력값이 올바른지 판별  

> e.g1  

```
Input: s = "()"
Output: true
```

> e.g2  

```
Input: s = "()[]{}"
Output: true
```  

> e.g3)

```
Input: s = "(]"
Output: false
```

**Solution**  

1. Stack을 이용하여 Open('(', '{','[')일 경우 Push, Close(')', '}', ']')일 경우 Stack에서 Pop후 매칭 여부 검사

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
        Character ch = chars[i];
        Character open = getOpen(ch);
        if (open == null) { // open
            stack.push(ch);
        } else { // close
            if (stack.isEmpty()) {
                return false;
            }
            if (!stack.pop().equals(open)) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}

public Character getOpen(char ch) {
    switch (ch) {
        case ')':
            return '(';
        case '}':
            return '{';
        case ']':
            return '[';
    }
    return null;
}
```

---  

### 큐를 이용한 스택 구현

https://leetcode.com/problems/implement-stack-using-queues/  

**Problem**  

큐를 이용하여 다음 연산을 지원하는 스택을 구현  

- `push(x)`: 요소 x를 스택에 삽입
- `pop()`: 스택의 첫 번째 요소를 삭제
- `peek()`: 스택의 첫번째 요소 반환
- `empty()`: 스택이 비어 있는지 여부를 리턴  

(큐는 `push`, `top`, `pop`, `empty`만 이용)

```  
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
```

**Solution**   

1. push() 할 때 큐를 이용해 재정렬  

```java
public class MyStack2 {
    Queue<Integer> que;

    public MyStack2() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.offer(x);
        for (int i = 0; i < que.size() - 1; i++) {
            que.offer(que.poll());
        }
    }

    public int pop() {
        return que.poll();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.size() == 0;
    }
}
```

2. push() 할 때 요소를 head로 변경  

```java
public class MyStack {
    Queue<Integer> que;

    public MyStack() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);
        while (!que.isEmpty()) {
            temp.add(que.poll());
        }
        que = temp;
    }

    public int pop() {
        return que.poll();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.size() == 0;
    }
}
```  

---  

<br /><br /><br /><br />

### 정리 탬플릿

https://leetcode.com/problems


**Problem**  

문제 설명

> e.g1  

```
Input: s = "()"
Output: true
```

> e.g2  

```
Input: s = "()[]{}"
Output: true
```  

> e.g3)

```
Input: s = "(]"
Output: false
```

**Solution**  
