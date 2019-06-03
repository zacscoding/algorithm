# ch16. 비트마스크  
; 내부적으로 이진수를 사용하는 컴퓨터들은 이진법 관련 연산들을 더 빠르게 함  
=> 이와 같은 특성을 이용해 정수의 이진수 표현을 자료 구조로 쓰는 기법을  
비트마스크(bitmask) 라고 함  

## 도입

> 장점  

- 더 빠른 수행 시간  
; 비트마스크 연산은 O(1)에 구현되는 것이 많기 때문에 굉장히 여러 번 수행해야 할  
경우에는 작은 최적화도 큰 속도 향상을 가져올 수 있음  
- 더 간결한 코드  
; 다양한 집합 연산들을 반복문 없이 한 줄에 쓸 수 있기 때문에 비트마스크를  
적절히 사용하면 굉장히 짧은 코드를 작성할 수 있음  
- 더 작은 메모리 사용량  
; 메모리를 더 적게 사용한다는 것은 더 많은 데이터를 미리 계산해서 저장해 둘 수 있음  
- 연관 배열을 배열로 대체  
; map<verctor<bool>, int>가 있을 때 비트마스크로 int[] 값을 사용해 같은 정보를  
나타낼 수 있음  

> 용어 정의  

부호 없는 N비트 정수(N자리 이진수)일 때, 2^N-1는 최상위 비트(most significant bit)  
, 2^0 최하위 비트(least significant bit)라고 표현 함  

> 비트 연산자  

- 논리곱 AND(&)  
; 둘다 켜져 있으면 결과의 비트를 킴  

```
a = 160, b=245 ==> a&b
     1 0 1 0 0 0 0 0
AND  1 1 1 1 0 1 0 1
---------------------
     1 0 1 0 0 0 0 0
```  

- 논리합 OR(|)  
; 두 비트 중 하나라도 켜져 있으면 결과의 비트를 켬  

```
a = 160, b=245 ==> a|b
     1 0 1 0 0 0 0 0
OR   1 1 1 1 0 1 0 1
---------------------
     1 1 1 1 0 1 0 1
```  

- 베타적 논리합 XOR(^)  
; 각 비트가 다를 경우만 결과의 비트를 켬  

```
a = 160, b=245 ==> a^b
     1 0 1 0 0 0 0 0
XOR  1 1 1 1 0 1 0 1
---------------------
     0 1 0 1 0 1 0 1
```  

- NOT 비트 연산(~)  
; 켜져 있는 비트는 끄고, 꺼져 있는 비트는 켬  

```
a = 160 ==> ~a
00000000000000000000000010100000
11111111111111111111111101011111
```  

- 쉬프트 연산  

```
178 >> 2
    0 0 1 0 1 1 0 0 1 0
--------------
    1 0 1 1 0 0 1 0 0 0
```

> 유의 할 점  

- 연산자 우선순위

```
int c = ( 6 & 4 == 4);
```  

=> &,|,^등 비트 연산자의 우선순위는 == 혹은 != 등의 비교 연산자 보다 낮음  
=> 4==4 먼저 계산되고 결과인 1이 6과 비트별 AND 되어 c는 0이 됨  

- 오버플로  

```
// a의 b번 비트가 켜져 있는지 확인하는 코드
bool isBitSet(unsigned long long a, int b) {
  return (a & (1 << b)) > 0;
}
```  

=> 1은 부호 있는 32비트 상수로 취급되기 때문에, b 가 32보다 크면 오버플로  

## 피자집 예제  
; 피자에 0~19의 번호를 가지는 토핑이 존재할 경우  


### 공집합과 꽉 찬 집합 구하기  

- 공집합 == 상수 0
- 꽉 찬 집합  
```
int fullPizza = (1 << 20) -1;

e.g)
10000 <== 1 << 4
1111 <== (1 <<4) -1
```  

### 원소 추가  

```aidl
  toppings |= (1 << p);  , where 0<= p < 20
```  

### 원포 포함 여부   

(주 : 연산 결과는 0 or (1 << p) )

```aidl
if( (toppings & ( 1 << p)) ) true
```  

### 원소 삭제  

```aidl
toppings &= ~(1 << p);
```  

### 원소의 토글  
; 해당 비트가 켜져 있으면 끄고, 꺼져 있으면 켬  

```aidl
toppings ^= ( 1 << p);
```  

### 두 집합에 대해 연산하기  

```aidl
int added = ( a | b);             // a 와 b 의 합집합
int intersection = ( a & b);   // a 와 b 의 교집합
int removed = ( a & ~b);      // a에서 b를 뺀 차집합
int toggled = (a ^ b);            // a와 b중 하나에만 포함된 원소들의 집합
```  

### 집합의 크기 구하기  

```aidl
int bitCount(int x) {
  return x % 2 + bitCouint(x / 2);
}
```  

- 라이브러리  

gcc/g++   : __builtin_pocount(toppings)  
Visual C++ : __popcnt(toppings)  
Java : Integer.bitCount(toppings)

### 최소 원소 찾기  (e.g : 40 일 경우 3)

- 라이브러리  
  
gcc/g++   : __builtin_ctz(toppings)  
Visual C++ : __NotScamFprward(&index, toppings)  
Java : Integer.numberOfTrailingZeros(toppings)  

### 최소 원소 값 찾기 ( e.g : 40 일 경우 2^3 == 8 )  

```aidl
int firstTopping = (toppings & -toppings)
```  

=> 음수 (-toppings) 는 NOT 연산 후 1을 더함  
=> 켜진 최하위 비트가 2^i 라고 가정  
=> ~(toppings)는 i번째는 0 & i-1 까지는 다 1  
=> ~(toppings) + 1 은  i 번째는 1 , i-1 까지 다 0, i+1 부터는 NOT 적용  
=> (toppings & -toppings) == 2^i    

### 최소 원소 지우기  

```aidl
toppings &= (toppings -1)  
```    

=> (toppings -1) 은 0~i-1 까지는 모두 1, i 번째는 0, i+1 번째부터는 그대로  
=> toppings & (toppings -1) 은 i번째 까지는 모두 0 / i +1 번째 부터는 그대로  

=> 어떤 수가 2의 거듭제곱인지 체크할 수 있음  
(2의 거듭제곱 값들의 이진수 표현에는 켜진 비트가 1개)  

### 모든 부분 집합 순회하기  

```aidl
for ( int subset = pizza; subset; subset = ( (subset - 1) & pizza ) {
  // subset은 pizza의 부분 집합
}
```  

=> (subset -1) 은 켜져 있는 최하위 비트를 끄고 하위 비트는 모두 켬  
=> (subset -1) & pizza 는 최하위 비트를 제거 한 토핑  

```aidl
e.g) 토핑이 1101 일 경우 subset 값들
1101
1100
1001
1000
0101
0100
0001  
```
 

### 피자집 예제 소스코드

```
public class PizzaOrder {

    int toppings = 1;

    // 원소 추가
    void add(int topping) {
        toppings |= 1 << topping;
    }

    // 원소 삭제
    void remove(int topping) {
        toppings &= ~(1 << topping);
    }

    // 원소 토글
    void toggle(int topping) {
        toppings ^= (1 << topping);
    }

    // 원소 포함 여부 확인
    boolean has(int topping) {
        return (toppings & (1 << topping)) != 0;
    }

    int firstTopping() {
        // Sol1 )
        int zeros = Integer.numberOfTrailingZeros(toppings);
        return 2 >> zeros;

        // Sol2 )
//        int firstTopping = (toppings & - toppings);
//        return firstTopping;
    }

    // 최소 원소 지우기
    void removeFirstElt() {
        toppings &= (toppings - 1);
        // 101000
        // 000001
        // ======
        // 100111 (최소 원소는0 그 밑으로는 다 비트를 켬)
        //&101000
        // ======
        // 100000
        // 응용 : 2^x 인지 체크할 때 => 최소 원소를 지운 뒤 0인지 아닌지로 판별
    }

    // 모든 부분 집합 순회 (공집합은 제외)
    static void traversalSubset(int toppingsCount) {
        int pizza = (1 << toppingsCount) -1;

        for (int subset = pizza; subset != 0; subset = ((subset - 1) & pizza)) {
            System.out.println(subset);
        }
    }

    // 최소 원소 찾기
    static int trailingZeros(int toppings) {
        return Integer.numberOfTrailingZeros(toppings);
    }

    // 전체 토핑을 추가한 값
    static int fullPizza() {
        return (1 << 20) - 1;
    }

    // 집합의 크기 구하기 bit count1
    static int bitCount(int x) {
        if (x == 0) {
            return 0;
        }

        return x % 2 + bitCount(x / 2);
    }

    // 집합의 크기 구하기 bit count2
    static int bitCount2(int x) {
        return Integer.bitCount(x);
    }

    public static void main(String[] args) {
        PizzaOrder.traversalSubset(2);
    }
}
```  






































---  
