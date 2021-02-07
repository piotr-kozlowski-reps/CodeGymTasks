package pl.codegym.task.task15.task1530;

public class TeaMaker extends DrinkMaker{

    @Override
    public void getRightCup(){
        System.out.println("Weź kubek na herbatę");
    }

    @Override
    public void addIngredients() {
        System.out.println("Nalej herbaty");
    }

    @Override
    public void pour() {
        System.out.println("Napełnij wrzątkiem");
    }


}
