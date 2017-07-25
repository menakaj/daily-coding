package hackerrank.java;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTest {

    static BigInteger bigOne;
    static BigInteger bigTwo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        bigOne = scanner.nextBigInteger();
        bigTwo = scanner.nextBigInteger();

        System.out.println(bigOne.add(bigTwo));
        System.out.println(bigOne.multiply(bigTwo));

    }

}
