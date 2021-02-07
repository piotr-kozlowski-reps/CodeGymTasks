package com.codegym.task.task24.task2405;

/* 
Black box

*/

public class Solution implements Action {
    public static int actionObjectCount;

    private int param;

    private Action solutionAction = new Action() {

        public void someAction() {
            //write your code here
            for (int i = param; i > 0; i--){
                System.out.println(i);
            }

            if (param > 0){
                Action firstActionImplementation = new FirstClass() {
                    @Override
                    public Action getDependentAction() {

                        super.someAction();

                        return new Action() {
                            @Override
                            public void someAction() {
                            }
                        };
                    }
                };

                firstActionImplementation.someAction();

                Action secondActionImplementation = new SecondClass(){
                };

                secondActionImplementation.someAction();
                param = 0;
                System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);
            } else {

                Action secondActionImplementation = new SecondClass(){
                };
                secondActionImplementation.someAction();
                System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);

            }
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * FirstClass class, someAction method
     * SecondClass class, someAction method
     * Specific action for anonymous SecondClass, param = 0
     * The number of created Action objects is 2
     * SecondClass class, someAction method
     * Specific action for anonymous SecondClass, param = -1
     * The number of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("The number of created Action objects is " + actionObjectCount);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("The number of created Action objects is " + actionObjectCount);
    }
}
