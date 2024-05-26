package test.java;

import main.java.NumberProcessor;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MathTest {

    @Test
    public void testAll() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        Map<String, long[]> answers = readFileStatistics("testfiles/statistics.txt");
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking " + file.getName());
                long actualMin = NumberProcessor.min(filename);
                long expectedMin = answers.get(file.getName())[0];
                assertEquals("Min in " + file.getName() + " must be " + expectedMin, expectedMin, actualMin);

                long actualMax = NumberProcessor.max(filename);
                long expectedMax = answers.get(file.getName())[1];
                assertEquals("Max in " + file.getName() + " must be " + expectedMax, expectedMax, actualMax);

                long actualSum = NumberProcessor.sum(filename);
                long expectedSum = answers.get(file.getName())[2];
                assertEquals("Sum in " + file.getName() + " must be " + expectedSum, expectedSum, actualSum);

                long actualMult = NumberProcessor.mult(filename);
                long expectedMult = answers.get(file.getName())[3];
                assertEquals("Mult in " + file.getName() + " must be " + expectedMult, expectedMult, actualMult);
            }
        }
    }
    public static Map<String, long[]> readFileStatistics(String filePath) {
        Map<String, long[]> fileStatisticsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String fileName = parts[0];
                    long[] parameters = new long[4];
                    for (int i = 0; i < 4; i++) {
                        parameters[i] = Long.parseLong(parts[i + 1]);
                    }
                    fileStatisticsMap.put(fileName, parameters);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileStatisticsMap;
    }
}