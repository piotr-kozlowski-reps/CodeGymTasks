package com.codegym.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }


    //
    public static Car create(int type, int numberOfPassengers){

        switch (type){
            case TRUCK:
                return new Truck(numberOfPassengers);

            case SEDAN:
                return new Sedan(numberOfPassengers);

            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);

            default:
                return null;
        }
    }

    public void fill(double numberOfGallons) throws Exception{
        if (numberOfGallons < 0) throw new Exception();
        else fuel += numberOfGallons;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd){
        boolean isSummerBoolean = false;
        if (date.after(summerStart) && date.before(summerEnd)) isSummerBoolean = true;
        return isSummerBoolean;
    }

    public double getWinterConsumption(int lenght){
        double consumption;
        consumption = lenght * winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    public double getSummerConsumption(int lenght){
        double consumption;
        consumption = lenght * summerFuelConsumption;
        return consumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        double consumption;
        if (isSummer(date, summerStart, summerEnd)) consumption = getSummerConsumption(length);
        else consumption = getWinterConsumption(length);
        return consumption;
    }

    private boolean canPassengersBeCarried(){
        boolean isCanPassengersBeCarried = false;
        if (isDriverAvailable() && fuel > 0) isCanPassengersBeCarried = true;
        return isCanPassengersBeCarried;
    }

    public int getNumberOfPassengersThatCanBeCarried() {
        if (canPassengersBeCarried()) return numberOfPassengers;
        else return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) fastenPassengerBelts();
    }

    public void fastenPassengerBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}