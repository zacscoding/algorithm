package chap16.example;


/**
 * @author zacconding
 * @Date 2019-01-08
 * @GitHub : https://github.com/zacscoding
 */
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
