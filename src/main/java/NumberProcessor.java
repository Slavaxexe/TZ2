package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public static long sum(String filename) throws IOException {
        long[] numbers = readNumbersFromFile(filename);
        long sum = 0;
        for (long num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static long mult(String filename) throws IOException {
        long[] numbers = readNumbersFromFile(filename);
        long mult = 1;
        for (long num : numbers) {
            mult *= num;
        }
        return mult;
    }
}