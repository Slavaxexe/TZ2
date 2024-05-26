package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class NumberProcessor {

    public static void main(String[] args) {
    }

    public static long[] readNumbersFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int count = 0;
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();

        long[] numbers = new long[count];
        reader = new BufferedReader(new FileReader(filename));
        int i = 0;
        while ((line = reader.readLine()) != null) {
            numbers[i] = Long.parseLong(line);
            i++;
        }
        reader.close();
        return numbers;
    }

    public static long min(String filename) throws IOException {
        long[] numbers = readNumbersFromFile(filename);
        long min = Long.MAX_VALUE;
        for (long num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static long max(String filename) throws IOException {
        long[] numbers = readNumbersFromFile(filename);
        long max = Long.MIN_VALUE;
        for (long num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static BigInteger sum(String filename) throws IOException {
        long[] numbers = readNumbersFromFile(filename);
        BigInteger sum = BigInteger.valueOf(0);
        for (long num : numbers) {
            sum = sum.add(BigInteger.valueOf(num));
        }
        return sum;
    }

    public static BigInteger mult(String filename) throws IOException {
        long[] numbers = readNumbersFromFile(filename);
        BigInteger mult = BigInteger.valueOf(1);
        for (long num : numbers) {
            mult = mult.multiply(BigInteger.valueOf(num));
        }
        return mult;
    }
}