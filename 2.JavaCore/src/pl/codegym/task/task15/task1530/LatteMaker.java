package pl.codegym.task.task15.task1530;

public class LatteMaker extends DrinkMaker{

    @Override
    public void getRightCup() {
        System.out.println("Weź kubek na latte");
    }

    @Override
    public void addIngredients() {
        System.out.println("Zrób kawę");
    }

    @Override
    public void pour() {
        System.out.println("Napełnij spienionym mlekiem");
    }
}
