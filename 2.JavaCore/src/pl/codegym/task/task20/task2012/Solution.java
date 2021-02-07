package pl.codegym.task.task20.task2012;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* 
OutputToConsole
*/

//OutputToConsole
//Klasa OutputToConsole musi być serializowana za pomocą interfejsu Externalizable.
//Znajdź błąd i napraw go.





public class Solution {

    public static String greeting = "Witaj, świecie";

    /**
     * OutputToConsole jest wewnętrzną klasą macierzystą dla poprawienia Twojej koncentracji.
     * Obiekt OutputToConsole zawiera informacje potrzebne
     * do wyświetlenia zmiennej [greeting] na konsoli.
     * @author CodeGym
     */
    public static class OutputToConsole implements Externalizable {

        private int counter;

        /**
         * @param out A strumień dla eksternalizacji
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A strumień dla de-eksternalizacji
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Konstruktor klasy, który tworzy prywatne pole counter.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Drukuje wiadomość powitalną do konsoli tyle razy ile wynosi counter.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) {

    }
}
