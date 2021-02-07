package pl.codegym.task.task20.task2015;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Nadpisywanie serializacji
*/

//Nadpisywanie serializacji
//Spraw, aby wątek runner po deserializacji kontynuował pracę.
//Nie zmieniaj słów kluczowych obiektu runner.
//
//Wskazówka:
//Konstruktor nie jest wywoływany podczas deserializacji. Inicjalizowane są jedynie wszystkie pola.



//4. Metoda readObject musi tworzyć nowy obiekt Thread z bieżącym obiektem jako argumentem.
//5. Metoda readObject musi wywoływać metodę start w nowym obiekcie Thread.



public class Solution implements Runnable, Serializable{

    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        System.out.println("odpalilem watek runner!!");
    }

    /**
     Nadpisz serializację.
     Aby to zrobić, musisz zadeklarować następujące metody:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Teraz serializacja/deserializacja będzie realizowała nasz scenariusz :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {

    }
}
