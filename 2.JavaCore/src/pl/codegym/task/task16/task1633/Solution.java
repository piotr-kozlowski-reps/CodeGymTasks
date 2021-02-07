package pl.codegym.task.task16.task1633;

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Wątek 1");
        Thread threadB = new Thread(commonThread, "Wątek 2");

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setDefaultUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Mój komunikat o wyjątku");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
