package pl.codegym.task.task14.task1408;

public class AfricanHen extends Hen{

//    static String kontynent = "Afryka";
//    static int ileJajZnosze = 100;

    @Override
    int getMonthlyEggCount() {
        return 100;
    }

    public String getDescription() {
        return super.getDescription() + " Pochodzę z " + Continent.AFRICA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
//        return super.getDescription() + ". Pochodzę z " + Continent.AFRICA + ". Znoszę " + this.getMonthlyEggCount() + " jaj na miesiac.";

//        return String.format("%s. Pochodzę z %s. Znoszę %d jaj na miesiąc.", super.getDescription(), Continent.AFRICA.toString(), this.getMonthlyEggCount());
//        return super.getDescription() + "Pochodze z " + Continent.AFRICA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiac";
    }

}
