package pl.codegym.task.task19.task1903;

/* 
Dostosowywanie wielu interfejsów
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<String, String> countries = new HashMap<>();                      //1. Klasa Solution musi mieć publiczne statyczne pole Map<String, String> o nazwie countries.

    //2. Inicjalizuj pole countries w bloku statycznym w klasie Solution, korzystając z danych testowych dostarczonych w zadaniu.
    //Inicjalizuj countries przed uruchomieniem programu. Mapowanie pomiędzy kodami krajów i nazwami krajów:
    //UA Ukraina
    //US Stany Zjednoczone
    //FR Francja
    static {
        countries.put("UA", "Ukraina");
        countries.put("US", "Stany Zjednoczone");
        countries.put("FR", "Francja");
    }


    public static void main(String[] args) {

/*
        String cyfryNumeruZaimportowane = "991234567";              //991234567
        String cyfraKierunkowaZaimportowana = "1";                  // 1

        //dodaje zera by bylo 10 cyfr
        int ileZerDolozyc = 10 - cyfryNumeruZaimportowane.length();
        for (int i = 0; i < ileZerDolozyc; i++){
            cyfryNumeruZaimportowane = "0" + cyfryNumeruZaimportowane;
        }

        // tworze finalny String w wymaganej formie ->  Na przykład: +1(099)123-45-67
        String sformatowanyString =
                "+" + cyfraKierunkowaZaimportowana
                + "(" + cyfryNumeruZaimportowane.charAt(0) + cyfryNumeruZaimportowane.charAt(1) + cyfryNumeruZaimportowane.charAt(2) + ")"
                + cyfryNumeruZaimportowane.charAt(3) + cyfryNumeruZaimportowane.charAt(4) + cyfryNumeruZaimportowane.charAt(5)
                + "-" + cyfryNumeruZaimportowane.charAt(6) + cyfryNumeruZaimportowane.charAt(7)
                + "-" + cyfryNumeruZaimportowane.charAt(8) + cyfryNumeruZaimportowane.charAt(9);
*/







/*                String cyfryNumeruZaimportowane = "";          //991234567
                String cyfraKierunkowaZaimportowana = "1";
                String[] cyfryNumeruArray = new String[10];
                String phoneNumberFormatted = "";

                // zera na dzien dobry w Array
                for (int i = 0; i < cyfryNumeruArray.length; i++){
                    cyfryNumeruArray[i] = "0";
                }

                //przyporzadkowanie cyfr
                int ileCyfrBrakujeDo10 = 10 - cyfryNumeruZaimportowane.length();
                for (int i = ileCyfrBrakujeDo10; i < 10; i++){
                    cyfryNumeruArray[i] = Character.toString(cyfryNumeruZaimportowane.charAt(i - ileCyfrBrakujeDo10));
                }

                // Na przykład: +1(099)123-45-67
                phoneNumberFormatted = "+" + cyfraKierunkowaZaimportowana
                        + "(" +  cyfryNumeruArray[0] + cyfryNumeruArray[1] + cyfryNumeruArray[2] + ")"
                        + cyfryNumeruArray[3] + cyfryNumeruArray[4] + cyfryNumeruArray[5]
                        + "-" + cyfryNumeruArray[6] + cyfryNumeruArray[7]
                        + "-" + cyfryNumeruArray[8] + cyfryNumeruArray[9];

        System.out.println(phoneNumberFormatted);
*/


    }

    //3. Klasa IncomeDataAdapter musi implementować interfejsy Customer i Contact.
    public static class IncomeDataAdapter implements  Customer, Contact{

        //4. Klasa IncomeDataAdapter musi posiadać prywatne pole IncomeData o nazwie data.
        private IncomeData data;

        //5. Klasa IncomeDataAdapter musi posiadać konstruktor z parametrem IncomeData.
        public IncomeDataAdapter (IncomeData data){
            this.data = data;
        }

        @Override
        public String getCompanyName(){
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countryNameInIncomeData = data.getCountryCode();
            String countryNameForCustomerInterface = "";

            // przeglądam HashMap wyszukując countryCode w kluczach -> zapisuje Value gdy pasuje
            for(Map.Entry<String, String> mapaPara : countries.entrySet()){
                String mapaParaKey = mapaPara.getKey();
                if (mapaParaKey.equals(countryNameInIncomeData)){
                    countryNameForCustomerInterface = mapaPara.getValue();
                }
            }
            return countryNameForCustomerInterface;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

        String cyfryNumeruZaimportowane = Integer.toString(data.getPhoneNumber());              //991234567
        String cyfraKierunkowaZaimportowana = Integer.toString(data.getCountryPhoneCode());                  // 1

        //dodaje zera by bylo 10 cyfr
        int ileZerDolozyc = 10 - cyfryNumeruZaimportowane.length();
        for (int i = 0; i < ileZerDolozyc; i++){
            cyfryNumeruZaimportowane = "0" + cyfryNumeruZaimportowane;
        }

        // tworze finalny String w wymaganej formie ->  Na przykład: +1(099)123-45-67
        String sformatowanyString =
                "+" + cyfraKierunkowaZaimportowana
                + "(" + cyfryNumeruZaimportowane.charAt(0) + cyfryNumeruZaimportowane.charAt(1) + cyfryNumeruZaimportowane.charAt(2) + ")"
                + cyfryNumeruZaimportowane.charAt(3) + cyfryNumeruZaimportowane.charAt(4) + cyfryNumeruZaimportowane.charAt(5)
                + "-" + cyfryNumeruZaimportowane.charAt(6) + cyfryNumeruZaimportowane.charAt(7)
                + "-" + cyfryNumeruZaimportowane.charAt(8) + cyfryNumeruZaimportowane.charAt(9);

            return  sformatowanyString;
        }

    }


    public static interface IncomeData {
        String getCountryCode();        // Na przykład: US

        String getCompany();            // Na przykład: CodeGym Ltd.

        String getContactFirstName();   // Na przykład: John

        String getContactLastName();    // Na przykład: Smith

        int getCountryPhoneCode();      // Na przykład: 1

        int getPhoneNumber();           // Na przykład: 991234567
    }

    public static interface Customer {
        String getCompanyName();        // Na przykład: CodeGym Ltd.

        String getCountryName();        // Na przykład: Stany Zjednoczone
    }

    public static interface Contact {
        String getName();               // Na przykład: Smith, John

        String getPhoneNumber();        // Na przykład: +1(099)123-45-67
    }
}