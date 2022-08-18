public class StepTracker {
 int TargetStep = 10000;
    Converter converter = new Converter();
        MonthData[] monthToData;

        public StepTracker() {
            monthToData = new MonthData[12];
            for (int i = 0; i < monthToData.length; i++) {
                monthToData[i] = new MonthData();
            }
        }

        static class MonthData {
           int[] daysDate = new int[30];
        }
    void saveCountStep(int month, int day, int step) { monthToData[month-1].daysDate[day-1] = step;
    }
    void statistic(int mohth) {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + monthToData[mohth - 1].daysDate[i]);
        }

        int sum = 0;
        int maxStep = 0;
        int average = 0;
        for (int i = 0; i < 30; i++) {
            sum = sum + monthToData[mohth - 1].daysDate[i];
            average = sum / 30;
            if ((monthToData[mohth - 1].daysDate[i]) > maxStep) {
                maxStep = monthToData[mohth - 1].daysDate[i];
            }
        }

        System.out.println("Общее количество шагов за месяц - " + sum);
        System.out.println("Максимальное количество шагов - " + maxStep);
        System.out.println("Среднее количество шагов - " + average);
        System.out.println("Пройденная дистанция - " + converter.distance(sum) + " км");
        System.out.println("Сожженые калории - " + converter.kalor(sum));
        maxSeries(mohth);
    }

    void GoalStep(int goal) {
        System.out.println("Новая цель по количеству шагов " + goal);
        TargetStep = goal;
    }

    void maxSeries(int month) {

        int index = 0;

        int max = 0;

        for (int i = 0; i < 30; i++) {
            if (monthToData[month-1].daysDate[i] >= TargetStep) {
                index++;
                if (index > max) {
                    max = index;
                }
            } else {
                index = 0;
            }

        }
        System.out.println("Лучшая серия по количеству шагов: " + max);
    }
}



