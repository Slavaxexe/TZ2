package test.java;

import main.java.NumberProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TimeoutTests {

    @Test
    public void testMinTimeout() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking timeout of " + file.getName());
                Assertions.assertTimeout(Duration.ofMillis(100), () -> {
                    NumberProcessor.min(filename);
                });
            }
        }
    }

    @Test
    public void testMaxTimeout() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking timeout of " + file.getName());
                Assertions.assertTimeout(Duration.ofMillis(100), () -> {
                    NumberProcessor.max(filename);
                });
            }
        }
    }

    @Test
    public void testSumTimeout() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking timeout of " + file.getName());
                Assertions.assertTimeout(Duration.ofMillis(100), () -> {
                    NumberProcessor.sum(filename);
                });
            }
        }
    }

    @Test
    public void testMultTimeout() throws IOException {
        String directoryPath = "testfiles/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("statistics.txt")) continue;
                String filename = file.getAbsolutePath();
                System.out.println("Cheking timeout of " + file.getName());
                Assertions.assertTimeout(Duration.ofMillis(100), () -> {
                    NumberProcessor.mult(filename);
                });
            }
        }
    }
}
