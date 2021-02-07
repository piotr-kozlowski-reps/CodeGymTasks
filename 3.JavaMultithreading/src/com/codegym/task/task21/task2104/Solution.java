package com.codegym.task.task21.task2104;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode

*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if (this == n) return true;
        if (!(n instanceof Solution)) return false;

        Solution solutionToCompare = (Solution) n;
        if (first != null ? !first.equals(solutionToCompare.first) : solutionToCompare.first != null) return false;
        if (last != null ? !last.equals(solutionToCompare.last) : solutionToCompare.last != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 1;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
