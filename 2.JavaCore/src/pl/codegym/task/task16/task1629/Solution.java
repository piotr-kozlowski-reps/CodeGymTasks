package pl.codegym.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();

/*        try{
            t1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }*/

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{

        String[] stringiTrzy = new String[3];

        public void run() {
            try{
                for (int i = 0; i < 3; i++){
                    String str = Solution.reader.readLine();
                    stringiTrzy[i] = str;
                }
            } catch (Exception e){
            }
        }



        public void printResult(){
            for (int i = 0; i < stringiTrzy.length; i++){
                if (i < stringiTrzy.length -1 ){
                    System.out.print(stringiTrzy[i] + " ");
                } else {
                    System.out.print(stringiTrzy[i] + "\n");
                }
            }
        }




    }
}
