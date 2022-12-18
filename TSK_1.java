import java.util.Arrays;
import java.util.Scanner;

public class TSK_1
{
    static int CheckNumbers(String param)
    {
        Scanner iScanner = new Scanner(System.in);
        while (true)
        {
            System.out.printf(param + ": ");
            if (iScanner.hasNextInt() == true)
            {
                int number = iScanner.nextInt();
                if (number > 0)
                {
                    iScanner.close();
                    return number;
                }
                else System.out.println("Число введено неправильно.");
            }
            else System.out.println("Число введено неправильно.");
            iScanner.next();
        }
    }

    static int[] ArrayGen(int number)
    {
        int[] array = new int[number];
        for (int i = 1; i < number; i++)
        {
            array[i] = (int)(Math.random() * 100);
        }
        return array;
    }

    public static int[] mergesort(int[] array)
    {
        int[] temp1 = Arrays.copyOf(array, array.length);
        int[] temp2 = new int[array.length];
        int[] result = mergesortInner(temp1, temp2, 0, array.length);
        return result;
    }

    public static int[] mergesortInner(int[] temp1, int[] temp2, int start, int end)
    {
        if (start >= end - 1)
        {
            return temp1;
        }
        int middle = start + (end - start) / 2;
        int[] sorted1 = mergesortInner(temp1, temp2, start, middle);
        int[] sorted2 = mergesortInner(temp1, temp2, middle, end);
        int index1 = start;
        int index2 = middle;
        int destIndex = start;
        int[] result = sorted1 == temp1 ? temp2 : temp1;
        while (index1 < middle && index2 < end)
        {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle)
        {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < end)
        {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
    public static void main(String[] args)
    {
        int number = CheckNumbers("Введите число элементов в массиве");
        int[] array = ArrayGen(number);
        System.out.println("Сгенерирован массив:");
        System.out.println(Arrays.toString(array));
        int[] result = mergesort(array);
        System.out.println("Массив после сортировки слиянием:");
        System.out.println(Arrays.toString(result));
    }
}