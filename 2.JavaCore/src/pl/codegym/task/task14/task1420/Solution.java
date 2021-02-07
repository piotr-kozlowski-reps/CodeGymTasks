package pl.codegym.task.task14.task1420;

/* 
NWD
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        int liczba1 = 0;
        int liczba2 = 0;
        int nwd = 0;

        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            liczba1 = Integer.parseInt(bf.readLine());
            liczba2 = Integer.parseInt(bf.readLine());
            bf.close();
        } catch (Exception e){
//            System.out.println(e);
        }

        List<Integer> dzielnikiLiczby1 = new ArrayList<Integer>();
        List<Integer> dzielnikiLiczby2 = new ArrayList<Integer>();
        List<Integer> wspolneDzielniki = new ArrayList<Integer>();
        
        dzielnikiLiczby(liczba1, dzielnikiLiczby1);
        dzielnikiLiczby(liczba2, dzielnikiLiczby2);

//       System.out.println(dzielnikiLiczby1); // wywal
//       System.out.println(dzielnikiLiczby2); // wywal

        System.out.println(nwd(dzielnikiLiczby1, dzielnikiLiczby2, wspolneDzielniki));






    }

    private static void dzielnikiLiczby(int liczba1, List<Integer> dzielnikiLiczby) {
        for (int i = liczba1; i > 0; i--){
            if (liczba1 % i == 0){
                dzielnikiLiczby.add(i);
            }
        }
    }

    private static int nwd(List<Integer> dzielnikiLiczby1, List<Integer> dzielnikiLiczby2, List<Integer> wspolneDzielniki){

        for (int i = 0; i < dzielnikiLiczby1.size(); i++){
            for (int j = 0; j < dzielnikiLiczby2.size(); j++){

                if (dzielnikiLiczby1.get(i) == dzielnikiLiczby2.get(j)){
                    wspolneDzielniki.add(dzielnikiLiczby1.get(i));
                }

            }
        }

//        System.out.println(wspolneDzielniki);

        int najwieksza = wspolneDzielniki.get(0);
        for (int i = 0; i < wspolneDzielniki.size(); i++){
            if (wspolneDzielniki.get(i) > najwieksza){
                najwieksza = wspolneDzielniki.get(i);
            }
        }

        return najwieksza;

    }

}
