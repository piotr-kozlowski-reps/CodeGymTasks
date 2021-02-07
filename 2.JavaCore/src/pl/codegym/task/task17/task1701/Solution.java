package pl.codegym.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Notatki
*/

public class Solution {
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Inny wątek usunął naszą notatkę");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Thread [" + threadName + "] usunął czyjąś notatkę [" + note + "]");
            } else {
                System.out.println("Thread [" + threadName + "] usunął swoją własną notatkę [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Thread{

        @Override
        public void run() {

            try{
                for (int i = 0; i < 1000; i++){
                    Note.addNote(getName() + "-Note" + i);
                    Thread.sleep(1);
                    Note.removeNote(getName());
                }
            } catch (InterruptedException e){
            }

        }
    }
}
