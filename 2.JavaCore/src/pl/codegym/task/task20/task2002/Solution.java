package pl.codegym.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* 
Odczytywanie i zapisywanie do pliku: CodeGym
*/
public class Solution {

    public static void main(String[] args) {
        // Plik your_file_name.tmp znajdziesz w swoim folderze plików tymczasowych, ewentualnie dostosuj outputStream/inputStream do rzeczywistej lokalizacji pliku
        try {
            File yourFile = File.createTempFile("plik27", null, new File("c:\\!!programowanie\\cwiczenia_pliki\\pliki29\\"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            CodeGym codeGym = new CodeGym();
            // Inicjalizuj tutaj pole users dla obiektu codeGym
            User user1 = new User();
            user1.setFirstName("FirstName");
            user1.setLastName("LastName");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.UNITED_STATES);
            codeGym.users.add(user1);

            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);

            // Sprawdź tutaj, czy obiekt codeGym jest taki sam jak obiekt loadedObject
            System.out.println(codeGym.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, coś jest nie tak z moim plikiem");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, coś jest nie tak z metodą save/load");
        }
    }

    public static class CodeGym {

        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriterToFile = new PrintWriter(outputStream);

            // are there assets
            int howManyUsers = users.size();
            printWriterToFile.println(howManyUsers);
            printWriterToFile.flush();

            if (howManyUsers > 0){

                for (int i = 0; i < howManyUsers; i++){

                    String firstName = users.get(i).getFirstName();
                    printWriterToFile.println(firstName);
                    printWriterToFile.flush();

                    String lastName = users.get(i).getLastName();
                    printWriterToFile.println(lastName);
                    printWriterToFile.flush();

                    Date data = users.get(i).getBirthDate();
                    DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    String dataJakoString = formatDaty.format(data);
                    printWriterToFile.println(dataJakoString);
                    printWriterToFile.flush();

                    String isMaleInString = Boolean.toString(users.get(i).isMale());
                    printWriterToFile.println(isMaleInString);
                    printWriterToFile.flush();

                    String whatCountry = users.get(i).getCountry().getDisplayName();
                    printWriterToFile.println(whatCountry);
                    printWriterToFile.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReaderFromFile = new BufferedReader(new InputStreamReader(inputStream));
            int howManyUsers = Integer.parseInt(bufferedReaderFromFile.readLine());

            if (howManyUsers > 0){

                for (int i = 0; i < howManyUsers; i++){
                    User user = new User();

                    String firstName = bufferedReaderFromFile.readLine();
                    user.setFirstName(firstName);

                    String lastName = bufferedReaderFromFile.readLine();
                    user.setLastName(lastName);

                    Date data = new Date();
                    SimpleDateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    data = formatDaty.parse(bufferedReaderFromFile.readLine());
                    user.setBirthDate(data);

                    String isMaleInString = bufferedReaderFromFile.readLine();
                    if (isMaleInString.equals("true")) {
                        user.setMale(true);
                    } else {
                        user.setMale(false);
                    }

                    String whatCountry = bufferedReaderFromFile.readLine();
                    if (whatCountry.equals("Stany Zjednoczone")) user.setCountry(User.Country.UNITED_STATES);
                    if (whatCountry.equals("Wielka Brytania")) user.setCountry(User.Country.UNITED_KINGDOM);
                    if (whatCountry.equals("Pozostałe")) user.setCountry(User.Country.OTHER);

                    this.users.add(user);

                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CodeGym codeGym = (CodeGym) o;

            return Objects.equals(users, codeGym.users);
//            return o.equals(users, codeGym.users);
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
