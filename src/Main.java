import java.util.Scanner;

public class Main {
    public static void main(String[] arg) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.print("1 task 1" +'\n');
        System.out.print("2 task 2" +'\n');
        System.out.print("3 task 3" +'\n');
        System.out.print("4 exit" +'\n');
        int n = console.nextInt();
        switch (n) {
            case 1 -> Task1.task1();
            case 2 -> Task2.task2();
            case 3 -> Task3.task3();
            case 4 -> {
                return;
            }
        }
    }
}
