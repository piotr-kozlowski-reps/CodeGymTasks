package pl.codegym.task.task14.task1408;

public class EuropeanHen extends Hen{

//    static String kontynent = "Europa";
//    static int ileJajZnosze = 40;

    @Override
    int getMonthlyEggCount() {
        return 40;
    }

    public String getDescription() {
//        return String.format("%s. Pochodzę z %s. Znoszę %d jaj na miesiąc.", super.getDescription(), Continent.EUROPE.toString(), this.getMonthlyEggCount());
//        return super.getDescription() + ". Pochodzę z " + Continent.EUROPE + ". Znoszę " + this.getMonthlyEggCount() + " jaj na miesiac.";
        return super.getDescription() + " Pochodzę z " + Continent.EUROPE + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";

    }
}
