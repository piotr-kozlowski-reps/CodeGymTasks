package pl.codegym.task.task14.task1408;

public class NorthAmericanHen extends Hen{

//    static String kontynent = "Polnocna Ameryka";
//    static int ileJajZnosze = 20;

    @Override
    int getMonthlyEggCount() {
        return 20;
    }

    public String getDescription() {
//        return String.format("%s. Pochodzę z %s. Znoszę %d jaj na miesiąc.", super.getDescription(), Continent.NORTHAMERICA.toString(), this.getMonthlyEggCount());
//        return super.getDescription() + ". Pochodzę z " + Continent.NORTHAMERICA + ". Znoszę " + this.getMonthlyEggCount() + " jaj na miesiac.";
        return super.getDescription() + " Pochodzę z " + Continent.NORTHAMERICA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
    }
}
