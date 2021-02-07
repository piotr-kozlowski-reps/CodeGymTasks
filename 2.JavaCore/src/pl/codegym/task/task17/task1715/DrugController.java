package pl.codegym.task.task17.task1715;

import java.util.HashMap;
import java.util.Map;

public class DrugController {
    public static Map<Drug, Integer> allDrugs = new HashMap<>();   // <Lek, Ilość>

    static {
        Drug acetaminophen = new Drug();
        acetaminophen.setName("Paracetamol");
        allDrugs.put(acetaminophen, 5);

        Drug metamizole = new Drug();
        metamizole.setName("Metamizol");
        allDrugs.put(metamizole, 18);

        Drug placebo = new Drug();
        placebo.setName("Placebo");
        allDrugs.put(placebo, 1);
    }

    public synchronized void buy(Drug drug, int count) {
        String name = Thread.currentThread().getName();
        if (!allDrugs.containsKey(drug)) {
            System.out.println("Wyprzedany");
        }
        Integer currentCount = allDrugs.get(drug);
        if (currentCount < count) {
            System.out.println(String.format("%s chce %d tabletek %s. Na stanie: %d", name, count, drug.getName(), currentCount));
        } else {
            allDrugs.put(drug, (currentCount - count));
            System.out.println(String.format("%s kupił %d tabletek %s. Pozostało: %d", name, count, drug.getName(), (currentCount - count)));
        }
    }

    public synchronized void sell(Drug drug, int count) {
        System.out.println(Thread.currentThread().getName() + " Zakup: " + count + " " + drug.getName());
        if (!allDrugs.containsKey(drug)) {
            allDrugs.put(drug, 0);
        }
        Integer currentCount = allDrugs.get(drug);
        allDrugs.put(drug, (currentCount + count));
    }
}
