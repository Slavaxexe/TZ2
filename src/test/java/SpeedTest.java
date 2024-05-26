package test.java;

import main.java.NumberProcessor;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpeedTest {
    @Test
    public void testMinPerformance() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = MathTest.readFileStatistics("testfiles/statistics.txt");

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;

                String filename = file.getAbsolutePath();
                System.out.println("Checking speed of " + file.getName());

                long startTime = System.nanoTime();
                long actualMin = NumberProcessor.min(filename);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Execution time for min function on " + file.getName() + ": " + duration + " nanoseconds");

                long expectedMin = (long) answers.get(file.getName())[0];
                assertEquals("Min in " + file.getName() + " must be " + expectedMin, expectedMin, actualMin);
            }
        }
    }
    @Test
    public void testMaxPerformance() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = MathTest.readFileStatistics("testfiles/statistics.txt");
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;

                String filename = file.getAbsolutePath();
                System.out.println("Checking speed of " + file.getName());

                long startTime = System.nanoTime();
                long actualMax = NumberProcessor.max(filename);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Execution time for max function on " + file.getName() + ": " + duration + " nanoseconds");

                long expectedMax = (long) answers.get(file.getName())[1];
                assertEquals("Max in " + file.getName() + " must be " + expectedMax, expectedMax, actualMax);
            }
        }
    }

    @Test
    public void testSumPerformance() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = MathTest.readFileStatistics("testfiles/statistics.txt");

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;

                String filename = file.getAbsolutePath();
                System.out.println("Checking speed of " + file.getName());

                long startTime = System.nanoTime();
                BigInteger actualSum = NumberProcessor.sum(filename);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Execution time for sum function on " + file.getName() + ": " + duration + " nanoseconds");

                BigInteger expectedSum = (BigInteger) answers.get(file.getName())[2];
                assertEquals("Sum in " + file.getName() + " must be " + expectedSum, expectedSum, actualSum);
            }
        }
    }

    @Test
    public void testMultPerformance() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = MathTest.readFileStatistics("testfiles/statistics.txt");

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;

                String filename = file.getAbsolutePath();
                System.out.println("Checking speed of " + file.getName());

                long startTime = System.nanoTime();
                BigInteger actualMult = NumberProcessor.mult(filename);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Execution time for mult function on " + file.getName() + ": " + duration + " nanoseconds");

                BigInteger expectedMult = (BigInteger) answers.get(file.getName())[3];
                assertEquals("Mult in " + file.getName() + " must be " + expectedMult, expectedMult, actualMult);
            }
        }
    }
}
