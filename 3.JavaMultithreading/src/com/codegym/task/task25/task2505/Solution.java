package com.codegym.task.task25.task2505;

/* 
No idiots

*/

public class Solution {

    public static void main(String[] args) throws Exception{
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) throws Exception{
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("This is an example");
        }


        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

            MyUncaughtExceptionHandler(){
            }

            @Override
            public void uncaughtException(Thread t, Throwable e){

                try{
                    Thread.sleep(500);
                } catch (InterruptedException ignored){}

                String message = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                System.out.println(message);
            }
        }
    }

}