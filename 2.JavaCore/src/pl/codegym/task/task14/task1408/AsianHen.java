package pl.codegym.task.task14.task1408;

public class AsianHen extends Hen{

//    static String kontynent = "Afryka";
//    static int ileJajZnosze = 60;

    @Override
    int getMonthlyEggCount() {
        return 60;
    }

    public String getDescription() {
        return super.getDescription() + " Pochodzę z " + Continent.ASIA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiąc.";
//        return super.getDescription() + ". Pochodzę z " + Continent.ASIA + ". Znoszę " + this.getMonthlyEggCount() + " jaj na miesiac.";
//        return String.format("%s. Pochodzę z %s. Znoszę %d jaj na miesiąc.", super.getDescription(), Continent.ASIA.toString(), this.getMonthlyEggCount());
//        return super.getDescription() + "Pochodze z " + Continent.ASIA + ". Znoszę " + getMonthlyEggCount() + " jaj na miesiac";
    }
}
