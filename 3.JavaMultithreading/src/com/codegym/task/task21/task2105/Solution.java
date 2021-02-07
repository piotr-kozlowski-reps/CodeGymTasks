package com.codegym.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Fix the bug. Comparing objects

*/


public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

/*    @Override
    public boolean equals(Object o) {
        //3. The equals method should check whether the passed object is a Solution object.
        if ( o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;


        //4. The equals method must return true if the first and last fields are equal to the passed object
        // and the current one (don't forget that they might be null).
        Solution n = (Solution) o;
        return n.first.equals(this.first) && n.last.equals(this.last);
    }*/

/*    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + (first == null ? 0 : first.hashCode());
        hash = 31 * hash + (last == null ? 0 : last.hashCode());

        return hash;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }


    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
