import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n=== SMART EXPENSE TRACKER ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Monthly Report (Category Wise)");
            System.out.println("4. Split Expense with Friend");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine(); 

            if (ch == 1) {
                System.out.print("Date (DD-MM-YYYY): ");
                String date = sc.nextLine();
                System.out.print("Category (Food/Travel/College/Other): ");
                String cat = sc.nextLine();
                System.out.print("Amount: ");
                double amt = sc.nextDouble();
                sc.nextLine();
                System.out.print("Note: ");
                String note = sc.nextLine();
                manager.addExpense(new Expense(date, cat, amt, note));
            } else if (ch == 2) {
                manager.viewAll();
            } else if (ch == 3) {
                manager.monthlyReport();
            } else if (ch == 4) {
                System.out.print("Friend Name: ");
                String name = sc.nextLine();
                System.out.print("Total Amount: ");
                double amt = sc.nextDouble();
                sc.nextLine();
                manager.splitExpense(name, amt);
            } else if (ch == 5) {
                System.out.println("Bye! Data saved in expenses.txt");
                break;
            }
        }
        sc.close();
    }
}