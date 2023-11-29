import java.util.Scanner;
public class Credplan {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double downPaymentPercentage = 0.10;
        double annualInterestRate = 0.12;
        double monthlyPaymentRate = 0.05;

        double PurchP;
        while(true){
            try {
                System.out.print("Input the purchase price: $");
                PurchP = reader.nextDouble();
                break;
            
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numerical value.");
                reader.nextLine();
            }
        }
        double downPayment = PurchP * downPaymentPercentage;
        double loanAmount = PurchP - downPayment;
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyPayment = loanAmount * monthlyPaymentRate;

        System.out.printf("%-10s%-20s%-20s%-30s%-20s%s%n", "Month", "Balance Owed", "Interest Owed", "Principal Owed", "Payment", "Balance Remaining");

        for (int month = 1; loanAmount > 0; month++) {
            double interestOwed = loanAmount * monthlyInterestRate;
            double principalOwed = monthlyPayment - interestOwed;
            double remainingBalance = loanAmount - monthlyPayment;

            if (remainingBalance < 0) {
                remainingBalance = 0;
            }

            System.out.printf("%-10d$%-24.2f$%-19.2f$%-24.2f$%-19.2f$%-29.2f%n",
                    month, loanAmount, interestOwed, principalOwed, monthlyPayment, remainingBalance);

            loanAmount = remainingBalance;
        }
    }
}
