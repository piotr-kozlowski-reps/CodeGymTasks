package com.codegym.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Armani, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Lucky, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKlein, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        abstract class AbstractJeans implements Jeans{

            int id;
            int length;
            int size;
            double price;
            Company company;

            //
            AbstractJeans(int id, int length, int size, double price){
                this.id = id;
                this.length = length;
                this.size = size;
                this.price = price;
            }

            //
            @Override
            public int getLength(){
                return length;
            }

            @Override
            public int getSize(){
                return size;
            }

            @Override
            public int getId() {
                return id;
            }

            @Override
            public double getPrice() {
                return price;
            }

            @Override
            public String getTM() {
                return company.fullName;
            }

            @Override
            public String toString() {
                return this.getClass().getSimpleName() + "{" +
                        "id=" + id +
                        ", length=" + length +
                        ", size=" + size +
                        ", price=" + price +
                        '}';
            }
        }

        class Levis extends AbstractJeans{
            Levis (int id, int length, int size, double price){
                super(id, length,size,price);
                super.company = Company.Levis;
            }
        }

        class Armani extends AbstractJeans{
            Armani (int id, int length, int size, double price){
                super(id, length,size,price);
                super.company = Company.Armani;
            }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
                if (Company.Armani == company) {
                    jeans = new Armani(id, length, size, price);
                } else {
                    jeans = new AbstractJeans(id, length, size, price) {
                        public String getTM() {
                            return company.fullName;
                        }
                    };
                }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Armani("Armani"),
        Lucky("Lucky"),
        CalvinKlein("Calvin Klein");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}


//2. In the Util class, add the missing Java code to the getAllJeans method:
//2.1) figure out what the Util class's getAllJeans method already has
//2.2) create an abstract AbstractJeans class using the Jeans interface with one abstract method, and implement the remaining methods
//2.3) create Levis and Armani classes using AbstractJeans, and implement the remaining method
//2.4) Implement the toString() method in the AbstractJeans class (you can use Alt+Insert -> toString())
//2.5) the output of the AbstractJeans class's toString method should start with the name of the subclass, for example, Levis{id=1, length=34, size=6, price=150.0}


//6. A local Levis class that inherits the AbstractJeans class must be created in the Util class's getAllJeans method.
//7. A local Armani class that inherits the AbstractJeans class must be created in the Util class's getAllJeans method.
//8. The AbstractJeans class must implement a toString() method whose output starts with name of the subclass.
