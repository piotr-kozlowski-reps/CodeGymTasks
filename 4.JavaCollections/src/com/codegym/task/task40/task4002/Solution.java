//package com.codegym.task.task40.task4002;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.nio.charset.Charset;
//import java.util.List;
//
///*
//Again, POST, not GET
//
//*/
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        Solution solution = new Solution();
//        solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
//    }
//
//    public void sendPost(String url, String urlParameters) throws Exception {
//        HttpClient client = getHttpClient();
//        HttpPost request = new HttpPost(url);
//
//        request.addHeader("User-Agent", "Mozilla/5.0");
//
//        List<NameValuePair> listUrlParameters = URLEncodedUtils.parse(urlParameters, Charset.forName("UTF-8"));
//        request.setEntity(new UrlEncodedFormEntity(listUrlParameters));
//
//        HttpResponse response = client.execute(request);
//
//        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String responseLine;
//        while ((responseLine = bufferedReader.readLine()) != null) {
//            result.append(responseLine);
//        }
//
//        System.out.println("Response: " + result.toString());
//    }
//
//    protected HttpClient getHttpClient() {
//        return HttpClientBuilder.create().build();
//    }
//}
