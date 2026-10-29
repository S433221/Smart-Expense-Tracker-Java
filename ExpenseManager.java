import java.util.*;
import java.io.*;

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private final String FILE_NAME = "expenses.txt";

    public ExpenseManager() {
        loadFromFile(); 
    }

    public void addExpense(Expense e) {
        expenses.add(e);
        saveToFile();
        System.out.println("✓ Expense Added!");
    }

    public void viewAll() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses yet.");
            return;
        }
        for (Expense ex : expenses) {
            System.out.println(ex);
        }
    }

    public void monthlyReport() {
        HashMap<String, Double> map = new HashMap<>();
        double total = 0;
        for (Expense ex : expenses) {
            map.put(ex.category, map.getOrDefault(ex.category, 0.0) + ex.amount);
            total += ex.amount;
        }
        System.out.println("\n--- Monthly Report ---");
        for (String cat : map.keySet()) {
            System.out.println(cat + " : Rs." + map.get(cat));
        }
        System.out.println("TOTAL : Rs." + total);
    }

    public void splitExpense(String friendName, double amount) {
        double split = amount / 2;
        System.out.println(friendName + " should pay you: Rs." + split);
        
        addExpense(new Expense("today", "Split", split, "Split with " + friendName));
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense ex : expenses) {
                pw.println(ex.toFileString());
            }
        } catch (IOException e) {
            System.out.println("File save error: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    expenses.add(new Expense(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]));
                }
            }
        } catch (IOException e) {
            
        }
    }
}