package chap16.example;

import sun.security.util.AuthResources_it;

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
        PizzaOrder order = new PizzaOrder();
        order.add(4);
        System.out.println(order.firstTopping());
    }
}
