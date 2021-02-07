package pl.codegym.task.task20.task2011;

/* 
Externalizable dla mieszkań
*/

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Obligatoryjny publiczny konstruktor bezargumentowy.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Drukuje pola używane do testów!
         */
        public String toString() {
            return("Adres: " + address + "\n" + "Rok: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException{
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) {

    }
}
