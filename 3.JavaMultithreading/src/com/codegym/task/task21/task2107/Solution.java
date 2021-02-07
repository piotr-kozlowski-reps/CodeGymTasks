package com.codegym.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Deep cloning of a map

*/


//Don't forget about the equals and hashCode methods needed to correctly add User elements to the HashMap.







//1. The Solution class should support the Cloneable interface.
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            Object solutionClone = solution.clone();
            clone = (Solution) solutionClone;
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    //4. The Solution class must correctly implement the clone method.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solutionToBeCloned = new Solution();
        Map<String, User> usersToBeCloned = new LinkedHashMap();
        usersToBeCloned.putAll(this.users);
        solutionToBeCloned.users = usersToBeCloned;
        return solutionToBeCloned;
    }

    protected Map<String, User> users = new LinkedHashMap();

    //2. The User class should support the Cloneable interface.
    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        //3. The User class must correctly implement the clone method.
        @Override
        public Object clone() throws CloneNotSupportedException{
            return super.clone();
//            User user = new User(this.age, this.name);
//            return user;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User userToCompare = (User) o;
            if (age != userToCompare.age) return false;
            if (name != null ? !name.equals(userToCompare.name) : userToCompare.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result;
            result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);

            return result;
        }
    }
}
