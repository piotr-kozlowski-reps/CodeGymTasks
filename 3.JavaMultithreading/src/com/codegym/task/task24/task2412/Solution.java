package com.codegym.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Knowledge is power!

*/

public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {

                String stock1Name = (String) stock1.get("name");
                String stock2Name = (String) stock2.get("name");

                Date stock1Date = (Date) stock1.get("date");
                Date stock2Date = (Date) stock2.get("date");
                int stock1Year = stock1Date.getYear();
                int stock2Year = stock2Date.getYear();
                int stock1Month = stock1Date.getMonth();
                int stock2Month = stock2Date.getMonth();
                int stock1Day = stock1Date.getDay();
                int stock2Day = stock2Date.getDay();
                double stock1Profit = getChangeFromStock(stock1);
                double stock2Profit = getChangeFromStock(stock2);

                int result = stock1Name.compareTo(stock2Name);
                if (result == 0) {
                    result = Integer.compare(stock2Year, stock1Year);
                    if (result == 0){
                        result = Integer.compare(stock2Month, stock1Month);
                        if (result == 0){
                            result = Integer.compare(stock2Day, stock1Day);
                            if (result == 0){
                                result = Double.compare(stock2Profit, stock1Profit);
                            }
                        }
                    }
                }

                return result;
            }

            private double getChangeFromStock(Stock stock) {

                double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
                double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
                double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));

                if (open == 0 && last == 0 && change == 0){
                    return 0;
                } else if (change != 0){
                    return change;
                } else {
                    return last - open;
                }

            }

        });

    }

    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));

        //
        Date temporaryData = new Date();
        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, temporaryData));
        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", -.3, temporaryData));
        //

        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

