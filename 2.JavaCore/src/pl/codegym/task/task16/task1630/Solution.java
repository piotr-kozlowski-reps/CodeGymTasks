package pl.codegym.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static{
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = bf.readLine();
            secondFileName = bf.readLine();
            bf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join(); // czy aby tu??
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String nazwaPliku;
        List<String> wierszePliku = new ArrayList<String>();

        @Override
        public void setFileName(String fullFileName) {
            this.nazwaPliku = fullFileName;
        }

        @Override
        public void run() {
            try{
                BufferedReader fr = new BufferedReader(new FileReader(nazwaPliku));
                String linia;
                while((linia = fr.readLine()) != null){
                    wierszePliku.add(linia);
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }

        @Override
        public String getFileContents() {
            String caloscPliku = "";

            for (int i = 0; i < wierszePliku.size(); i++){
                if (i < wierszePliku.size()){
                    caloscPliku += wierszePliku.get(i) + " ";
                } else {
                    caloscPliku += wierszePliku.get(i);
                }
            }

            return caloscPliku;
        }
    }
}
