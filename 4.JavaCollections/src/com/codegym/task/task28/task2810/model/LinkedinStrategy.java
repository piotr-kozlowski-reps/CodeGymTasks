package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy {

    //fields
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";


    @Override
    public List<JobPosting> getJobPostings(String searchString) {

        List<JobPosting> jobPostingsList = new ArrayList<>();

        Document doc = null;
        try {
            doc = getDocument(searchString, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.getElementsByClass("jobs-search-result-item");

        for (Element specificElement : elements) {

            //String title, city, companyName, websiteName, url;
            JobPosting jobPosting = new JobPosting();
            jobPosting.setTitle(specificElement.getElementsByClass("listed-job-posting__title").text());
            jobPosting.setCity(specificElement.getElementsByClass("listed-job-posting__location").text());
            jobPosting.setCompanyName(specificElement.getElementsByClass("listed-job-posting__company").text());
            Element linkToWWW = specificElement.select("meta[itemprop=url]").first();
            jobPosting.setUrl(linkToWWW.attr("content"));
            jobPosting.setWebsiteName(URL_FORMAT);

            if (!jobPostingsList.contains(jobPosting)) {
                jobPostingsList.add(jobPosting);
            }

        }

        return jobPostingsList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {

        Document doc = null;
        try {
            doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36")
                    .referrer("http://www.example.com")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }


}