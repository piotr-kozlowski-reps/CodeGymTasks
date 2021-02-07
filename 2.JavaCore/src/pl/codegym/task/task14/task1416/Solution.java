package pl.codegym.task.task14.task1416;

/* 
Naprawianie błędów
*/

public class Solution {
    public static void main(String[] args) {
        CanSwim creature = new Orca();
        creature.swim();
        creature = new Whale();
        creature.swim();
        creature = new RiverOtter();
        creature.swim();
    }

    public static void test(CanSwim creature) {
        creature.swim();
    }

    interface CanWalk {
        void walk();
    }

    interface CanSwim {
        void swim();
    }

    static abstract class SeaCreature implements CanSwim{
        public void swim() {
            SeaCreature currentCreature = (SeaCreature) getCurrentCreature();
            currentCreature.displaySwim();
        }

        private void displaySwim() {
            System.out.println(getCurrentCreature().getClass().getSimpleName() + " pływa");
        }

        abstract CanSwim getCurrentCreature();
    }

    static class Orca extends SeaCreature implements CanSwim{
        @Override
        CanSwim getCurrentCreature() {
            CanSwim orca = new Orca();
            return orca;
        }
    }

    static class Whale extends SeaCreature implements CanSwim{


        @Override
        CanSwim getCurrentCreature() {
            CanSwim whale = new Whale();
            return whale;
        }
    }

    static class RiverOtter implements CanWalk, CanSwim{

        @Override
        public void walk() {
            System.out.println("idę");
        }

        @Override
        public void swim() {
            RiverOtter currentCreature = (RiverOtter) getCurrentCreature();
            currentCreature.displaySwim();
        }

        CanSwim getCurrentCreature(){
            RiverOtter riverOtter = new RiverOtter();
            return riverOtter;
        }

        private void displaySwim() {
            System.out.println(getCurrentCreature().getClass().getSimpleName() + " pływa");
        }

    }
}
