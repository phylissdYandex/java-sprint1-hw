import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker steptracker = new StepTracker();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Укажите месяц: 1 - январь, 2 - февраль, " +
                        "3 - март, 4- апрель, 5 - май, 6 - июнь, 7 - июль, 8 - август, 9 - сентябрь, " +
                        "10 - октябрь, 11- ноябрь, 12 - декабрь");
                int month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Можно указать только от 1 до 12, попробуйте снова");
                    continue;
                }
                System.out.println("Укажите день начиная от 1 до 30: ");
                int day = scanner.nextInt();
                if (day < 1 || day > 30) {
                    System.out.println("Можно указать только от 1 до 30, попробуйте снова");
                    continue;
                }
                System.out.println("Укажите количество шагов: ");
                int step = scanner.nextInt();
                if (step > 0) {
                    steptracker.saveCountStep(month, day, step);
                    System.out.println("Значение сохранено!");
                } else {
                    System.out.println("Значение не может быть отрицательным");

                continue;
                }

            }

            if (userInput == 2) {
                System.out.println("Укажите месяц за который вы хотите получить статистику: ");
                int month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Можно указать только от 1 до 12, попробуйте снова");
                    continue;
                }
                steptracker.statistic(month);
                
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