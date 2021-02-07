package pl.codegym.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Wzmocnij adapter
*/

public class Solution {

    public static Map<String,String> countries = new HashMap<>();

    //Inicjalizuj countries przed uruchomieniem programu. Mapowanie pomiędzy kodami krajów i nazwami krajów:     //UA Ukraina     //US Stany Zjednoczone     //FR Francja
    static {
        countries.put("UA", "Ukraina");
        countries.put("US", "Stany Zjednoczone");
        countries.put("FR", "Francja");
    }

    public static void main(String[] args) {


/*

        String phoneNumberFormatted;

        String phoneNumberToParse = "+3(805)0123-4567";                  // +3(805)0123-4567    +1(111)222-3333        +380(50)123-4567
        String cyfryArray[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuilder wyciagnieteSameCyfry = new StringBuilder();

        // jeżeli char jest cyfrą - dodaję do String'a
        for (int i = 0; i < phoneNumberToParse.length(); i++){
            for (int j = 0; j < cyfryArray.length; j++){
                String znakZPhoneNumber = Character.toString(phoneNumberToParse.charAt(i));
                String znakZArray = cyfryArray[j];
                if (znakZPhoneNumber.equals(znakZArray)) wyciagnieteSameCyfry.append(znakZPhoneNumber);
            }
        }

        //sformatowanie textu na: callto://+11112223333
        phoneNumberFormatted = "callto://+" + wyciagnieteSameCyfry.toString();

        System.out.println(phoneNumberFormatted);
*/





    }

    //6. Klasa DataAdapter musi implementować interfejs RowItem.
    public static class DataAdapter implements RowItem{

        //7. Klasa DataAdapter musi zawierać dwa pola prywatne: Customer customer i Contact contact.
        private Customer customer;
        private Contact contact;

        //8. Klasa DataAdapter musi posiadać Konstruktor z parametrami (Customer customer, Contact contact). Musi on inicjalizować pola contact i customer.
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }



        //9. Implementuj metody interfejsu RowItem w klasie DataAdapter korzystając z podpowiedzi w komentarzach w interfejsach.

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getCountryCode(){
            String countryNameAsFullName = customer.getCountryName();
            String countryNameAsCode = "";

            // przeglądam HashMap wyszukując countryCode w kluczach -> zapisuje Value gdy pasuje
            for(Map.Entry<String, String> mapaPara : countries.entrySet()){
                String mapaParaValue = mapaPara.getValue();
                if (mapaParaValue.equals(countryNameAsFullName)){
                    countryNameAsCode = mapaPara.getKey();
                }
            }
            return countryNameAsCode;
        }

        @Override
        public String getContactFirstName(){
            String firstName;

            String contactStringToParse = contact.getName();
            String[] tokens = contactStringToParse.split(",\\s+");
            firstName = tokens[1];

            return firstName;
        }

        @Override
        public String getContactLastName() {
            String lastName;

            String contactStringToParse = contact.getName();
            String[] tokens = contactStringToParse.split(",\\s+");
            lastName = tokens[0];

            return lastName;
        }

        @Override
        public String getDialString() {

            String phoneNumberFormatted;

            String phoneNumberToParse = contact.getPhoneNumber();                  // +3(805)0123-4567    +1(111)222-3333        +380(50)123-4567
            String cyfryArray[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            StringBuilder wyciagnieteSameCyfry = new StringBuilder();

            // jeżeli char jest cyfrą - dodaję do String'a
            for (int i = 0; i < phoneNumberToParse.length(); i++){
                for (int j = 0; j < cyfryArray.length; j++){
                    String znakZPhoneNumber = Character.toString(phoneNumberToParse.charAt(i));
                    String znakZArray = cyfryArray[j];
                    if (znakZPhoneNumber.equals(znakZArray)) wyciagnieteSameCyfry.append(znakZPhoneNumber);
                }
            }

            //sformatowanie textu na: callto://+11112223333
            phoneNumberFormatted = "callto://+" + wyciagnieteSameCyfry.toString();

            return phoneNumberFormatted;
        }
    }

    public static interface RowItem {
        String getCountryCode();        // Na przykład: US
        String getCompany();            // Na przykład: CodeGym Ltd.
        String getContactFirstName();   // Na przykład: John
        String getContactLastName();    // Na przykład: Peterson
        String getDialString();         // Na przykład: callto://+11112223333
    }

    public static interface Customer {
        String getCompanyName();        // Na przykład: CodeGym Ltd.
        String getCountryName();        // Na przykład: Stany Zjednoczone
    }

    public static interface Contact {
        String getName();               // Na przykład: Peterson, John
        String getPhoneNumber();        // Na przykład: +1(111)222-3333, +3(805)0123-4567, +380(50)123-4567, etc.
    }
}


