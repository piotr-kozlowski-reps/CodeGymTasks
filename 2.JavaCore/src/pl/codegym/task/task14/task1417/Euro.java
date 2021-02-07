package pl.codegym.task.task14.task1417;

public class Euro extends Money{

    @Override
    public String getCurrencyName() {
        return "EUR";
    }

    public Euro(double amount){
        super(amount);
    }
}
