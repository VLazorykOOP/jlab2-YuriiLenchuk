import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public final class Task3 {
    public static void task3() {
        int size = 10;

        int[] array1 = generateRandomArray(size);
        int[] array2 = generateRandomArray(size);

        System.out.println("Початковий масив 1: " + Arrays.toString(array1));
        System.out.println("Початковий масив 2: " + Arrays.toString(array2));

        bubbleSort(array1);
        bubbleSort(array2);

        System.out.println("Відсортований масив 1: " + Arrays.toString(array1));
        System.out.println("Відсортований масив 2: " + Arrays.toString(array2));

        int[] mergedArray = joinAndSort(array1, array2);

        System.out.println("Об'єднаний та відсортований масив: " + Arrays.toString(mergedArray));
    }
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Обмін значень
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return array;
    }
    public static int[] joinAndSort(int[] a, int[] b)
    {
        return bubbleSort(IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray());
    }
}
