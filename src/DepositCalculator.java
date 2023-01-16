import java.util.Scanner;

public class DepositCalculator {

  double calculateComplexPercent(double valueOne, double valueTwo, int valueThree ) {
      double pay = valueOne * Math.pow((1 + valueTwo / 12), 12 * valueThree);

      return round(pay, 2);
  }

  double calculateSimplePercent(double doubleAmount, double yearRate, int depositPeriod) {
      return round(doubleAmount+doubleAmount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
       double ScaLe = Math.pow(10, places);

       return Math.round(value * ScaLe) / ScaLe;
}

    void openingDeposit() {
      int period;
      int action;

      Scanner userInput = new Scanner(System.in);
      System.out.println("Введите сумму вклада в рублях:");
      int amount = userInput.nextInt();
      System.out.println("Введите срок вклада в годах:");
      period = userInput.nextInt();
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      action = userInput.nextInt();

      double periodAmount = 0;

        if (action ==1) {
            periodAmount = calculateSimplePercent(amount, 0.06, period);
        }else if (action == 2) {
            periodAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + periodAmount);
    }

public static void main(String[] args) {
        new DepositCalculator().openingDeposit();
}

}
