package pl.codegym.task.task17.task1708;

import java.util.ArrayList;
import java.util.List;

/* 
Notatki dla wszystkich
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public volatile List<String> notes = new ArrayList<>();

        public void addNote(int index, String note) {
            System.out.println("Notatka [" + note + "] zostanie teraz dodana na pozycji " + index);
            notes.add(index, note);
            System.out.println("Notatka [" + note + "] została już dodana");
        }

        public void removeNote(int index) {
            System.out.println("Notatka zostanie teraz usunięta z pozycji " + index);
            String note = notes.remove(index);
            System.out.println("Notatka [" + note + "] została już usunięta z pozycji " + index);
        }
    }
}
