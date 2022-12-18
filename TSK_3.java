import java.util.Scanner;
import java.util.ArrayList;

public class TSK_3
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

    static ArrayList<Integer> ArrayGen(int number)
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < number; i++)
        {
            array.add((int)(Math.random() * 100));
        }
        return array;
    }

    static int FindMax(ArrayList<Integer> array)
    {
        int max = array.get(0);
        for (int i = 1; i < array.size(); i++)
        {
            if (array.get(i) > max) max = array.get(i);
        }
        return max;
    }   

    static int FindMin(ArrayList<Integer> array)
    {
        int min = array.get(0);
        for (int i = 1; i < array.size(); i++)
        {
            if (array.get(i) < min) min = array.get(i);
        }
        return min;
    }   

    static double FindMid(ArrayList<Integer> array)
    {
        double sum = 0;
        double mid;
        for (int i = 0; i < array.size(); i++)
        {
            sum = sum + array.get(i);
        }
        mid = sum / array.size();
        return mid;
    }   

public static void main(String[] args)
    {
        int number = CheckNumbers("Введите число элементов в массиве");
        ArrayList<Integer> array = ArrayGen(number);
        System.out.println("Сгенерирован список:");
        System.out.println(array);
        System.out.printf("Максимальное значение из списка: %d", FindMax(array));
        System.out.printf("\nМинимальное значение из списка: %d", FindMin(array));
        System.out.printf("\nСреднее значение из списка: %.2f", FindMid(array));
    }
}