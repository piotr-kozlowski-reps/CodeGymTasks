package pl.codegym.task.task14.task1417;

public abstract class Money {

    private double amount;

    public double getAmount(){
        return this.amount;
    }

    public Money(double amount) {
        this.amount = amount;
    }

//    public abstract double getAmount();

    public abstract String getCurrencyName();
}

