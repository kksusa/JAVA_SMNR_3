import java.util.Scanner;
import java.util.ArrayList;

public class TSK_2
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

    static ArrayList<Integer> RemoveOdd(ArrayList<Integer> array)
    {
        int i = 0;
        while (i < array.size())
        {
            if (array.get(i) % 2 == 0)
            {
                array.remove(i);
                i = 0;
            }
            else i++;
        }
        return array;
    }

    public static void main(String[] args)
    {
        int number = CheckNumbers("Введите число элементов в массиве");
        ArrayList<Integer> array = ArrayGen(number);
        System.out.println("Сгенерирован список:");
        System.out.println(array);
        ArrayList<Integer> result = RemoveOdd(array);
        System.out.println("Список без четных чисел:");
        System.out.println(result);
    }
}