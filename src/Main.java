import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String lessons[] = { "Математика", "Философия", "Основы ООП", "Английский", "SQL" };
    public static String names[] = { "Петрова", "Иванов", "Сидоров", "Алексеев", "Бондарев", "Медведев", "Морозова", "Новиков"};
    public static void main(String[] args) {

        Journal journal = new Journal(names, lessons);

        while (true) {
            System.out.println("\n1. Вывести журнал с оценками.\n" +
                                 "2. Напечатать имена студентов со средним баллом ниже 4.\n" +
                                 "3. Выход\n");
            int command = initCommand();
            //in.nextLine();
            switch (command) {
                case 1: {
                    journal.print();
                    break;
                }
                case 2: {
                    Map<String, Double> res = journal.findLessThen(4.0);
                    for (Map.Entry entry : res.entrySet()) {
                        System.out.printf("%10s %1.1f", entry.getKey(), entry.getValue());
                        System.out.println();
                    }
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Нема такого пункту меню");
                    break;
                }
            }
        }
    }
    private static int initCommand() {
        Scanner in = new Scanner(System.in);
        try {
            int command = in.nextInt();
            return command;
        }
        catch (InputMismatchException ex) {
            System.out.println("Потрібно ввести число\n");
            return -1;
        }
    }
}
