package pl.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Praktyka z blokami statycznymi
*/

public class Solution {
    public static void main(String[] args) throws IOException{

    }
    
    static {
        Solution.reset();
    }

    public static CanFly result;

    public static void reset(){

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linia;
            while(!((linia = br.readLine()) == null)){
                if (linia.equals("helikopter")){
                    Solution.result = new Helicopter();
                    br.close();
                } else if (linia.equals("samolot")){
                    String liniaDruga = br.readLine();
                    int liniaDrugaWInt = Integer.parseInt(liniaDruga);
                    Solution.result = new Plane(liniaDrugaWInt);
                    br.close();
                }
            }

        } catch (IOException e){

        }

    }
}
