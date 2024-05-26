import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filename = "numbers.txt"; // Замените на путь к вашему файлу с числами
        try {
            long[] numbers = readNumbersFromFile(filename);
            System.out.println("Минимальное число: " + min(numbers));
            System.out.println("Максимальное число: " + max(numbers));
            System.out.println("Сумма чисел: " + sum(numbers));
            System.out.println("Произведение чисел: " + mult(numbers));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
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

    public static long min(long[] numbers) {
        long min = Long.MAX_VALUE;
        for (long num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static long max(long[] numbers) {
        long max = Long.MIN_VALUE;
        for (long num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static long sum(long[] numbers) {
        long sum = 0;
        for (long num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static long mult(long[] numbers) {
        long mult = 1;
        for (long num : numbers) {
            mult *= num;
        }
        return mult;
    }
}