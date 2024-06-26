package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TestGenerator {

    private static final Random RANDOM = new Random();
    private static final String DIRECTORY = "testfiles/";
    private static final String STATISTICS_FILE = DIRECTORY + "statistics.txt";

    public static void main(String[] args) {
        createDirectory(DIRECTORY);
        generateFiles(1, 100000, 100);
    }

    private static void createDirectory(String directory) {
        try {
            Files.createDirectories(Paths.get(directory));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateFiles(int numberOfFiles, int numbersPerFile, int bound) {
        for (int i = 1; i <= numberOfFiles; i++) {
            String fileName = DIRECTORY + "numbers(npf" + numbersPerFile + ",b" + bound + ")" + i + ".txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                int[] numbers = generateNumbers(numbersPerFile, bound);
                writeNumbersToFile(writer, numbers);
                writeStatisticsToFile(numbers, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int[] generateNumbers(int count, int bound) {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = RANDOM.nextInt(bound) + 1;
        }
        return numbers;
    }

    private static void writeNumbersToFile(FileWriter writer, int[] numbers) throws IOException {
        for (int number : numbers) {
            writer.write(number + "\n");
        }
    }

    private static void writeStatisticsToFile(int[] numbers, String fileName) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger product = BigInteger.valueOf(1);

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            sum = sum.add(BigInteger.valueOf(number));
            product = product.multiply(BigInteger.valueOf(number));
        }
        File f = new File(fileName);
        String statistics = String.format("%s;%d;%d;%d;%d%n", f.getName(), min, max, sum, product);

        try (FileWriter statsWriter = new FileWriter(STATISTICS_FILE, true)) {
            statsWriter.write(statistics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}