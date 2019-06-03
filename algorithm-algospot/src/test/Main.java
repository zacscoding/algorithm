package test;

public class Main {

    public static void main(String[] args) {
        int pizza = 13;
        for (int subset = pizza; subset != 0; subset = (subset - 1) & pizza) {
            String binaryString = Integer.toBinaryString(subset);
            System.out.println(binaryString);
        }
    }
}


