package com.codegym.task.task22.task2201;

/* 
Threads of a string or stringy threads? That's the question

*/

public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\tgtr"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {

        if (string == null) throwAllExceptions(threadName);

        String[] splittedString = string.split("\t");

        if (splittedString.length < 3) throwAllExceptions(threadName);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < splittedString.length - 1; i++){
            if (i < splittedString.length - 2) result.append(splittedString[i]).append("\t");
            else result.append(splittedString[i]);
        }

        return result.toString();
    }

    private void throwAllExceptions(String threadName){
        if (threadName.equals(Solution.FIRST_THREAD_NAME)) throw new StringForFirstThreadTooShortException();
        if (threadName.equals(Solution.SECOND_THREAD_NAME)) throw new StringForSecondThreadTooShortException();
        else throw new RuntimeException();
    }

}




//3. Implement the logic of the three protected methods in OurUncaughtExceptionHandler using the corresponding method calls according to the following patterns:
//a) 1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
//b) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : StringForSecondThreadTooShortException : 2#
//c) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#

//5. The getFormattedStringForFirstThread method must return a string built using the arguments and formatted in accordance with the pattern specified in the task conditions.
//6. The getFormattedStringForSecondThread method must return a string built using the arguments and formatted in accordance with the pattern specified in the task conditions.
//7. The getFormattedStringForOtherThread method must return a string built using the arguments and formatted in accordance with the pattern specified in the task conditions.