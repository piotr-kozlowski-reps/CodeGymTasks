package com.codegym.task.task25.task2502;

import java.util.*;

/* 
Don't take the car to the shop!

*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;


        public Car() throws Exception{
                initWheels();
        }

        protected String[] loadWheelNamesFromDB() {
            // This method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }

        private void initWheels() throws Exception {

            List<Wheel> wheelsTemporaryToBeInitialized = new ArrayList<>();
            String[] wheelsAsArray = loadWheelNamesFromDB();
            int[] indexesOfWheelHit = {0, 0, 0 ,0};
            Wheel[] wheelENUMArray = Wheel.values();
            boolean isOnlyOneHit = true;

            // check if there's data that doesn't match ENUM at all
            for (int i = 0; i < wheelsAsArray.length; i++){
                int howManyTimesDoesntMatch = wheelENUMArray.length;

                for (Wheel wheel : wheelENUMArray){
                    if (!wheelsAsArray[i].equals(wheel.toString())) howManyTimesDoesntMatch--;
                }

                if(howManyTimesDoesntMatch == 0) throw new Exception();
            }


            for (int i = 0; i < wheelsAsArray.length; i++){
                for (int j = 0; j < Wheel.values().length; j++){
                    if (wheelsAsArray[i].equals(wheelENUMArray[j].toString())){
                        wheelsTemporaryToBeInitialized.add(wheelENUMArray[j]);
                        indexesOfWheelHit[j]++;
                    }
                }
            }

            for (int howManyHits : indexesOfWheelHit){
                if (howManyHits != 1) isOnlyOneHit = false;
            }

            if (isOnlyOneHit) wheels = wheelsTemporaryToBeInitialized;
            else throw new Exception();


        }
    }

    public static void main(String[] args) throws Exception{
        Car car = new Car();
    }
}
