package com.codegym.task.task36.task3612;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Why doesn't the set contain an element?

*/

public class Solution {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateInDates());
    }

    public boolean isLastDateInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(9999999L);
        dates.add(lastDate);
        dates.add(new Date(2222222L));
        dates.add(new Date(3333333L));
        dates.add(new Date(4444444L));
        dates.add(new Date(5555555L));
    }

    protected void updateLastDate(long delta) {

        dates.remove(lastDate);
        lastDate.setTime(lastDate.getTime() + delta);
        dates.add(lastDate);

    }
}



//Historians added several dates of past events to a special set in the initializeDates method.
// Later, they studied the historical documents more closely and more precisely calculated the
// time of the latest event lastDate. But what was their surprise when they found that the required
// date wasn't in the set. In other words, the isLastDateInDates method returns false.
//Amigo, your duty is to save history. Make the changes necessary to ensure that the date of the
// last event is in the dates set (i.e. the program returns true).


//3. The isLastDateInDates method must correctly return a boolean indicating whether lastDate is in dates.
//4. The number of elements in the dates set must not change after calling the updateLastDate method.
//5. The updateLastDate method must remove the old lastDate element from the dates set.
//6. The updateLastDate method must add the updated lastDate date to the dates set.