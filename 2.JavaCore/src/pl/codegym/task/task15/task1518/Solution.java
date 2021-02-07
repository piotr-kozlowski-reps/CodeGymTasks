package pl.codegym.task.task15.task1518;

/* 
Modyfikatory statyczne i kociaki
*/

public class Solution {

    static {
        Solution.cat = new Cat();
        Solution.cat.name = "cat";
        System.out.println(Solution.cat.name);
    }

    public static Cat cat;


    public static void main(String[] args) {

    }

    public static class Cat{
        public String name;
    }

}
