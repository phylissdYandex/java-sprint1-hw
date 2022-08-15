import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker steptracker = new StepTracker();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Укажите месяц: 0 - январь, 1 - февраль, " +
                        "2 - март, 3- апрель, 4 - май, 5 - июнь, 6 - июль, 7 - август, 8 - сентябрь, " +
                        "9 - октябрь, 10- ноябрь, 11 - декабрь");
                int month = scanner.nextInt();
                System.out.println("Укажите день: ");
                int day = scanner.nextInt();
                System.out.println("Укажите количество шагов: ");
                int step = scanner.nextInt();
                steptracker.saveCountStep(month, day, step);
                System.out.println("Значение сохранено!");
            }

            if (userInput == 2) {
                System.out.println("Укажите месяц за который вы хотите получить статистику: ");
                int month = scanner.nextInt();
                steptracker.statistic(month);
                steptracker.maxSeries(month);
            }

            if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов: ");
                int targetStep = scanner.nextInt();
                if (targetStep > 0) {
                    steptracker.GoalStep(targetStep);
                } else {
                    System.out.println("Цель по количеству шагов должна быть больше 0.");
                }
            }

            if (userInput == 4) {
                System.out.println("Выход");
                break;
            }


            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
    }

}