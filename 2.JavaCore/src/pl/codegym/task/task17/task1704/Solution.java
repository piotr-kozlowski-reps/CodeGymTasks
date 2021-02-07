package pl.codegym.task.task17.task1704;

import java.util.ArrayList;
import java.util.List;

/* 
Zsynchronizowane notatki: część 2
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public final List<String> notes = new ArrayList<>();

        public synchronized void addNote(int index, String note) {
            System.out.println("Notatka [" + note + "] zostanie teraz dodana na pozycji " + index);
            notes.add(index, note);
            System.out.println("Notatka [" + note + "] została już dodana");
        }

        public synchronized void removeNote(int index) {
            System.out.println("Notatka zostanie teraz usunięta z pozycji " + index);
            String note = notes.remove(index);
            System.out.println("Notatka [" + note + "] została już usunięta z pozycji " + index);
        }
    }
}