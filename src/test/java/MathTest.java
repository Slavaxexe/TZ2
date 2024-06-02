package test.java;

import main.java.NumberProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class MathTest {

    @Test
    public void testMin() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = readFileStatistics("testfiles/statistics.txt");
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking " + file.getName());

                long actualMin = NumberProcessor.min(filename);
                long expectedMin = (long) answers.get(file.getName())[0];
                Assertions.assertEquals(expectedMin, actualMin);
            }
        }
    }

    @Test
    public void testMax() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = readFileStatistics("testfiles/statistics.txt");
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking " + file.getName());

                long actualMax = NumberProcessor.max(filename);
                long expectedMax = (long) answers.get(file.getName())[1];
                Assertions.assertEquals(expectedMax, actualMax);
            }
        }
    }

    @Test
    public void testSum() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = readFileStatistics("testfiles/statistics.txt");
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking " + file.getName());

                BigInteger actualSum = NumberProcessor.sum(filename);
                BigInteger expectedSum = (BigInteger) answers.get(file.getName())[2];
                Assertions.assertEquals(expectedSum, actualSum);
            }
        }
    }

    @Test
    public void testMult() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, Object[]> answers = readFileStatistics("testfiles/statistics.txt");
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking " + file.getName());

                BigInteger actualMult = NumberProcessor.mult(filename);
                BigInteger expectedMult = (BigInteger) answers.get(file.getName())[3];
                Assertions.assertEquals(expectedMult, actualMult);
            }
        }
    }


    public static Map<String, Object[]> readFileStatistics(String filePath) {
        Map<String, Object[]> fileStatisticsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String fileName = parts[0];
                    Object[] parameters = new Object[4];
                    parameters[0] = Long.parseLong(parts[1]);
                    parameters[1] = Long.parseLong(parts[2]);
                    parameters[2] = new BigInteger(parts[3]);
                    parameters[3] = new BigInteger(parts[4]);
                    fileStatisticsMap.put(fileName, parameters);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileStatisticsMap;
    }

}