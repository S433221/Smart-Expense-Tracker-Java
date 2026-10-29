public class Expense {
    String date; 
    String category; 
    double amount;
    String note;

    public Expense(String date, String category, double amount, String note) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | Rs." + amount + " | " + note;
    }
    
    
    public String toFileString() {
        return date + "," + category + "," + amount + "," + note;
    }
}