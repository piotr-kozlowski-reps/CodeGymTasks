package pl.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, loser, coder i programmer
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        List<String> wczytanePersony = new ArrayList<String>();

        while (true) {

            key = reader.readLine();

            if (key.equals("user") || key.equals("loser") || key.equals("coder") || key.equals("programmer")){
                wczytanePersony.add(key);
            } else {
                reader.close();
                break;
            }
        }

        for (String iteracjaArrayList : wczytanePersony){
            if (iteracjaArrayList.equals("user")){
                person = new Person.User();
                doWork(person);
            } else if (iteracjaArrayList.equals("loser")){
                person = new Person.Loser();
                doWork(person);
            } else if (iteracjaArrayList.equals("coder")){
                person = new Person.Coder();
                doWork(person);
            } else if (iteracjaArrayList.equals("programmer")){
                person = new Person.Programmer();
                doWork(person);
            }
        }





    }

    public static void doWork(Person person) {
        if (person instanceof Person.User){
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Programmer){
            ((Person.Programmer) person).enjoy();
        }
    }
}
