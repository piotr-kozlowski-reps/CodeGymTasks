package pl.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

// jakie argumenty:
//-c:       -c MyNameOne m "04 15 1990" MyNameTwo f "12 01 1900" MyNameThree m "02 28 2001"
//-u:       -u 0 MyNameOne m "04 15 1990" 1 MyNameTwo f "12 01 1900"
//-d:       -d 1 0
//-i:       -i 1 0


public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {

        switch (args[0]){

            case "-c":
                synchronized (allPeople){
                    addPeople(args);
                    break;
                }

            case "-u":
                synchronized (allPeople){
                    updatePeople(args);
                    break;
                }

            case "-d":
                synchronized (allPeople){
                    deleteLogicalPeople(args);
                    break;
                }

            case "-i":
                synchronized (allPeople){
                    infoAboutPeople(args);
                    break;
                }

//            default:
//                System.out.println("WRONG args");

        }
    }

    public static void addPeople(String[] argumenty){

        // ile ludzi bede musial dodac
        int ileArgumentow = argumenty.length;
        double ileLudziDodacDouble = ((ileArgumentow * 1.0) - 1) / 3;
        int ileLudziDodacInt = (int) ileLudziDodacDouble;

        //
        // petla dodajaca do Listy
        for (int i = 0; i < ileLudziDodacInt; i++){

            int odJakiejLiczbyOdliczamArgumenty = i * 3;

            //name
            String name = argumenty[odJakiejLiczbyOdliczamArgumenty + 1];

            //plec
            Sex sex = null;
            String plec = argumenty[odJakiejLiczbyOdliczamArgumenty + 2];
            if (plec.equals("m")){
                sex = Sex.MALE;
            } else if (plec.equals("f")){
                sex = Sex.FEMALE;
            }

            // data
            Date data = null;
            try{
                SimpleDateFormat formatDaty = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
                String dataArgumenty = argumenty[odJakiejLiczbyOdliczamArgumenty + 3];
                data = formatDaty.parse(dataArgumenty);
            } catch (ParseException e){
                System.out.println("coś nie parsło!");
            }

            // dodaje do listy
            if (sex == Sex.MALE){
                allPeople.add(Person.createMale(name, data));
            } else if (sex == Sex.FEMALE){
                allPeople.add(Person.createFemale(name, data));
            }

            System.out.println(allPeople.size() - 1);

        }

        // wyświetlam IDs
//        int ileOdjac = 0;
//        for (int z = allPeople.size(); z > (allPeople.size() - ileLudziDodacInt); z--){
//            System.out.println(allPeople.size() - 1 - ileOdjac);
//            ileOdjac++;
//        }

    }

    public static void updatePeople(String[] argumenty){

        // ile ludzi dodaję
        int ileArgumentow = argumenty.length;
        double ileLudziDodacDouble = ((ileArgumentow * 1.0) - 1) / 4;
        int ileLudziDodacInt = (int) ileLudziDodacDouble;



        //
        // pętla updatująca na liście
        for (int i = 0; i < ileLudziDodacInt; i++){

            // od tej liczby w pętli odliczam argumenty
            int odJakiejLiczbyOdliczamArgumenty = i * 4;

            // jaki id
            int idArg = Integer.parseInt(argumenty[odJakiejLiczbyOdliczamArgumenty + 1]);

            // name
            String name = argumenty[odJakiejLiczbyOdliczamArgumenty + 2];

            // jaka płeć
            Sex sex = null;
            String plec = argumenty[odJakiejLiczbyOdliczamArgumenty + 3];
            if (plec.equals("m")){
                sex = Sex.MALE;
            } else if (plec.equals("f")){
                sex = Sex.FEMALE;
            }

            // data
            Date data = null;
            try{
                SimpleDateFormat formatDaty = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
                String stringData = argumenty[odJakiejLiczbyOdliczamArgumenty + 4];
                data = formatDaty.parse(stringData);
            } catch (ParseException e){
                System.out.println("coś nie parsło!");
            }

            // update na liście
            if (sex == Sex.MALE){
                allPeople.set(idArg, Person.createMale(name, data));
            } else if (sex == Sex.FEMALE){
                allPeople.set(idArg, Person.createFemale(name, data));
            }


        }



    }

    public static void deleteLogicalPeople(String[] argumenty){
        // ile ludzi bede musial dodac
        int ileArgumentow = argumenty.length - 1;

        for(int i = 0; i < ileArgumentow; i++){

            //ktory ID
            int ktoryID = Integer.parseInt(argumenty[i + 1]);

            //przypisuje NULL osobie z danym ID
            Person osobaNull = Person.createFemale("nazwa", new Date());
            osobaNull.setName(null);
            osobaNull.setSex(null);
            osobaNull.setBirthDate(null);
            allPeople.set(ktoryID, osobaNull);

        }

    }

    public static void infoAboutPeople(String[] argumenty){
        // ile ludzi bede musial dodac
        int ileArgumentow = argumenty.length - 1;

        for (int i = 0; i < ileArgumentow; i++){

            //ktory ID
            int ktoryID = Integer.parseInt(argumenty[i + 1]);

            // format daty
            SimpleDateFormat formaDaty = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

            // wywietlanie
            String nameOsoby = allPeople.get(ktoryID).getName();
            Sex plecOsoby = allPeople.get(ktoryID).getSex();
            Date dataUrodzin = allPeople.get(ktoryID).getBirthDate();

            if (plecOsoby.equals(Sex.MALE)){
                System.out.println(nameOsoby + " m " + formaDaty.format(dataUrodzin));
            } else {
                System.out.println(nameOsoby + " f " + formaDaty.format(dataUrodzin));
            }

        }

    }

}