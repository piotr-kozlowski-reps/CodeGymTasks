package com.codegym.task.task23.task2309;

import com.codegym.task.task23.task2309.vo.*;

import java.util.List;

/* 
Sometimes anonymity is so nice!

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers(){
        return new AbstractDbSelectExecutor<User>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }

    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>(){

            @Override
            public String getQuery(){
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }

    public List<Server> getServers(){
        return new AbstractDbSelectExecutor<Server>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }

    public List<Subject> getSubjects(){
        return new AbstractDbSelectExecutor<Subject>(){

            @Override
            public String getQuery(){
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions(){
        return new AbstractDbSelectExecutor<Subscription>(){

            @Override
            public String getQuery(){
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }


}

//3. In each of these methods, create an anonymous class from AbstractDbSelectExecutor and call the required method on it.
//Hint:
//the body of the method should begin like this: return new AbstractDbSelectExecutor
//
//4. Example output for User and Location:
//
//Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
//Id=1, name='Location-1', description=Received from executing 'SELECT * FROM LOCATION'
//5. Analyze the example output and create the correct query for all classes.

//6. An AbstractDbSelectExecutor object with a User parameter must be created in the getUsers method.
//        7. An AbstractDbSelectExecutor object with a Location parameter must be created in the getLocations method.
//        8. An AbstractDbSelectExecutor object with a Server parameter must be created in the getServers method.
//        9. An AbstractDbSelectExecutor object with a Subject parameter must be created in the getSubjects method.
//        10. An AbstractDbSelectExecutor object with a Subscription parameter must be created in the getSubscriptions method.
//        11. The getUsers method must return the correct list (according to the task conditions).
//        12. The getLocations method must return the correct list (according to the task conditions).
//        13. The getServers method must return the correct list (according to the task conditions).
//        14. The getSubjects method must return the correct list (according to the task conditions).
//        15. The getSubscriptions method must return the correct list (according to the task conditions).
