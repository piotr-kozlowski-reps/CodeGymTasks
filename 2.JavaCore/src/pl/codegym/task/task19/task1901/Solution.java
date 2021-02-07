package pl.codegym.task.task19.task1901;

/* 
TableAdapter
*/


//1. Klasa Solution musi mieć publiczny statyczny interfejs ATable.
//2. Klasa Solution musi mieć publiczny statyczny interfejs BTable.

public class Solution {
    public static void main(String[] args) {
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    //3. Klasa Solution musi mieć publiczną statyczną klasę TableAdapter.
    //4. Klasa TableAdapter musi implementować interfejs BTable.
    public static class TableAdapter implements BTable {

        private ATable aTable;                  //5. Klasa TableAdapter musi posiadać prywatne pole ATable o nazwie aTable.

        public TableAdapter(ATable aTable){     //6. Klasa TableAdapter musi posiadać konstruktor z parametrem ATable.
            this.aTable = aTable;
        }

        //7. Klasa TableAdapter musi nadpisywać metodę getHeaderText zgodnie z warunkami zadania.
        //Metoda getHeaderText powinna zwracać "[<username>] : <table name>". //Na przykład, "[Amigo] : DashboardTable".
        @Override
        public String getHeaderText() {
            return "[" + aTable.getCurrentUserName() + "] : " + aTable.getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}