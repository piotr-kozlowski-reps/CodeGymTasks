package pl.codegym.task.task14.task1411;

public interface Person {
    class User implements Person {
        void live() {
            System.out.println("Zazwyczaj po prostu żyję.");
        }
    }

    class Loser implements Person {
        void doNothing() {
            System.out.println("Zazwyczaj nie robię nic.");
        }
    }

    class Coder implements Person {
        void writeCode() {
            System.out.println("Zazwyczaj koduję.");
        }
    }

    class Programmer implements Person {
        void enjoy() {
            System.out.println("Życie jest piękne!");
        }
    }

}
