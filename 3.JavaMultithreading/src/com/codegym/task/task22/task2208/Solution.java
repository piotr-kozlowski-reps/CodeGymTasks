package com.codegym.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Build a WHERE query

*/

public class Solution {
    public static void main(String[] args) {

/*        //-------------------- wywal
        Map<String, String> mapaTest = new LinkedHashMap<>();
        mapaTest.put("name", "Johnson");
        mapaTest.put("country", "United States");
        mapaTest.put("city", "Los Angeles");
        mapaTest.put("age", null);

        System.out.println(getQuery(mapaTest));
        //-------------------- wywal*/


        //-------------------- wywal
        Map<String, String> mapaTest = new LinkedHashMap<>();
        mapaTest.put(null, null);
        mapaTest.put(null, null);
        mapaTest.put("age", null);

        System.out.println(getQuery(mapaTest));
        //-------------------- wywal

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder resultQuery = new StringBuilder();

        for (Map.Entry<String, String> pairFromMap : params.entrySet()){
            String key = "";
            String value = "";

            if (pairFromMap.getKey() != null) key = pairFromMap.getKey();
            else continue;

            if (pairFromMap.getValue() != null) value = pairFromMap.getValue();
            else continue;

            resultQuery.append(" and ").append(key).append(" = '").append(value).append("'");
        }

        return resultQuery.toString().equals("") ? "" : resultQuery.substring(5).toString();
    }
}
