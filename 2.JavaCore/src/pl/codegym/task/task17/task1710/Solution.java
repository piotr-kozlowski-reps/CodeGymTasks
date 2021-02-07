package pl.codegym.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/


// konfiruracje argumentów:
// -c:      -c MyName m "04 15 1990"
// -i:      -i 1
// -u:      -u 1 MyName m "04 15 1990"


public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        String argument = args[0];

        switch (argument){

            case "-c":
                addToList(args);
                break;

            case "-u":
                updateInLIst(args);
                break;

            case "-d":
                logicalDeleteFromList(args);
                break;

            case "-i":
                displayInfo(args);
                break;

            default:
                System.out.println("You put bad arguments - moron.");
        }
    }


    public static void displayInfo(String[] argumenty){

        // jaki ID
        int idArg = Integer.parseInt(argumenty[1]);
        DateFormat dataOsoby = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        Person osobaAktualna = allPeople.get(idArg);
        String plec = null;

        if (osobaAktualna.getSex().equals(Sex.MALE)){
            plec = "m";
        } else if (osobaAktualna.getSex().equals(Sex.FEMALE)){
            plec = "f";
        }

        System.out.println(osobaAktualna.getName() + " " + plec + " " + dataOsoby.format(osobaAktualna.getBirthDate()));


    }


    public static void logicalDeleteFromList(String[] argumenty){

        // jaki ID
        int idArg = Integer.parseInt(argumenty[1]);

        // przypisanie null
        Person personNull = Person.createMale("name", new Date());
        personNull.setName(null);
        personNull.setSex(null);
        personNull.setBirthDate(null);
        allPeople.set(idArg, personNull);

    }


    public static void updateInLIst(String[] argumenty){

        // jaki ID
        int idArg = Integer.parseInt(argumenty[1]);

        //name
        String name = argumenty[2];

        // sex
        Sex sex = null;
        String sexArg = argumenty[3].toLowerCase();
        char litraMlubF = sexArg.charAt(0);
        if (litraMlubF == 'm'){
            sex = Sex.MALE;
        } else if (litraMlubF == 'f'){
            sex = Sex.FEMALE;
        }

        // data
        Date data = null;
        try{
            SimpleDateFormat formatDaty = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
//            String dataArg = argumenty[4] + " " + argumenty[5] + " " + argumenty[6];
            String dataArg = argumenty[4];
            data = formatDaty.parse(dataArg);
        } catch (ParseException e){
        }

        // update listy

        if (sex == Sex.MALE){
            allPeople.set(idArg, Person.createMale(name, data));
        } else if (sex == Sex.FEMALE){
            allPeople.set(idArg, Person.createFemale(name, data));
        }

    }


    public static void addToList(String[] argumenty){

        //name
        String name = argumenty[1];

        // sex
        Sex sex = null;
        String sexArg = argumenty[2].toLowerCase();
        char litraMlubF = sexArg.charAt(0);
        if (litraMlubF == 'm'){
            sex = Sex.MALE;
        } else if (litraMlubF == 'f'){
            sex = Sex.FEMALE;
        }

        // data
        Date data = null;
        try{
            SimpleDateFormat formatDaty = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
            String dataArg = argumenty[3];
            data = formatDaty.parse(dataArg);
        } catch (ParseException e){
        }

        // dodaję do listy
        if (sex == Sex.MALE){
            allPeople.add(Person.createMale(name, data));
        } else if (sex == Sex.FEMALE){
            allPeople.add(Person.createFemale(name, data));
        }

        // wyswietla index
        int indexAktualny = allPeople.size();
        System.out.println(indexAktualny - 1);

    }



}
