package com.codegym.task.task23.task2304;

/* 
Inner 3

*/

//Inside the Solution class:
//1) use Task and MockDB to implement the private class TaskDataProvider, whose purpose is to update the tasks field.
//2) use String and MockDB to implement the private class NameDataProvider, whose purpose is to update the names field.



//3. The TaskDataProvider class must implement the DbDataProvider interface with a Task parameter.
//4. The NameDataProvider class must implement the DbDataProvider interface with a String parameter.
//5. The refreshAllData method in the TaskDataProvider class must save the result of the MockDB class's getFakeTasks method in the tasks list.
//6. The refreshAllData method in the NameDataProvider class must save the result of the MockDB class's getFakeNames method in the names list.


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider implements DbDataProvider{

        @Override
        public void refreshAllData(Map taskFromMapParameter) {
//            tasks = new ArrayList<Task>(taskFromMapParameter.keySet());
            tasks = MockDB.getFakeTasks(taskFromMapParameter);
        }
    }

    private class NameDataProvider implements DbDataProvider{

        @Override
        public void refreshAllData(Map stringFromMapParameter){
//            names = new ArrayList<String>(stringFromMapParameter.keySet());
            names = MockDB.getFakeNames(stringFromMapParameter);
        }

    }



    public static void main(String[] args) {

    }
}
