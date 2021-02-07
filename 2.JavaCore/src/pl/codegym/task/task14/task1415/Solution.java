package pl.codegym.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Usługi sprzątające
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (int i = 0; i < apartments.size(); i++){

            if ((apartments.get(i)) instanceof OneRoomApt){
                ((OneRoomApt) apartments.get(i)).clean1Room();
            } else if (apartments.get(i) instanceof TwoRoomApt){
                ((TwoRoomApt) apartments.get(i)).clean2Rooms();
            } else if (apartments.get(i) instanceof ThreeRoomApt){
                ((ThreeRoomApt) apartments.get(i)).clean3Rooms();
            }

        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("Posprzątano 1 pokój");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("Posprzątano 2 pokoje");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("Posprzątano 3 pokoje");
        }
    }
}
