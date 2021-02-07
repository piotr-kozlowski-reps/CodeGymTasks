package pl.codegym.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Zsynchronizowane notatki
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public final List<String> notes = new ArrayList<>();

        public void addNote(int index, String note) {
            System.out.println("Notatka [" + note + "] zostanie teraz dodana na pozycji " + index);
            synchronized (notes){
                notes.add(index, note);
            }
            System.out.println("Notatka [" + note + "] została już dodana");
        }

        public void removeNote(int index) {
            System.out.println("Notatka zostanie teraz usunięta z pozycji " + index);
            String note = notes.get(index);
            synchronized (notes){
                notes.remove(index);
            }
            System.out.println("Notatka [" + note + "] została już usunięta z pozycji " + index);
        }
    }

}
