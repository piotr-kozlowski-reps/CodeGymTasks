package com.codegym.task.task28.task2810.view;

import com.codegym.task.task28.task2810.Controller;
import com.codegym.task.task28.task2810.model.Strategy;
import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View{

    //fields
    Controller controller;
    private final String filePath = "./" + "4.JavaCollections/src/" + this.getClass().getPackage().toString().replace("package ", "").replaceAll("\\.", "/") + "/jobPostings.html";


    @Override
    public void update(List<JobPosting> jobPostings) {
        String body = getUpdatedFileContents(jobPostings);
        updateFile(body);
    }



    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    //
    public void emulateCitySelection() {
        controller.onCitySelected("Odessa");
    }

    private String getUpdatedFileContents(List<JobPosting> jobPostingList) {

        Document doc = null;
        try {
            doc = getDocument();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        Elements elementsWithTemplate = doc.getElementsByClass("template");
        Element copyOfElementsWithTemplate = elementsWithTemplate.clone().removeAttr("style").removeClass("template").get(0);

        //remove all prev vacancies
        Elements prevVacancies = doc.getElementsByClass("vacancy");

        for (Element redundant : prevVacancies) {
            if (!redundant.hasClass("template")) {
                redundant.remove();
            }
        }


        for (JobPosting jobToAdd : jobPostingList) {

            //<tr class="vacancy">
            // <td class="title"><a href="url"></a></td>
            // <td class="city"></td>
            // <td class="companyName"></td>
            //</tr>
            Element copySection = copyOfElementsWithTemplate.clone();
            Element jobLink = copySection.getElementsByAttribute("href").get(0);
            jobLink.appendText(jobToAdd.getTitle());
            jobLink.attr("href", jobToAdd.getUrl());
            Element city = copySection.getElementsByClass("city").get(0);
            city.appendText(jobToAdd.getCity());
            Element companyName = copySection.getElementsByClass("companyName").get(0);
            companyName.appendText(jobToAdd.getCompanyName());

            elementsWithTemplate.before(copySection.outerHtml());
        }

        return doc.html();
    }

    private void updateFile(String fileContent) {

        try (FileOutputStream fos = new FileOutputStream(new File(filePath));
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] bytes = fileContent.getBytes();
            bos.write(bytes);
            bos.flush();

        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();}

    }

    protected Document getDocument() throws IOException {
        Document doc = Jsoup.parse(new File(filePath), "UTF-8");
        return doc;
    }

}


////4. For each job posting, in a loop:
//4.1. Use the clone method to clone the tag template obtained in item 2.
//4.2. Get the element that has the "city" class. Write the city from the job posting in it.
//4.3. Get the element that has the "companyName" class. Write the company name from the job posting in it.
//4.4. Get the hyperlink element (<a> tag). Write the job title in it. Create a working hyperlink to the job posting in place of href="url".
//4.5. Add the outerHtml of the element that you wrote job data to, right before the template <tr class="vacancy template" style="display: none">.
//
//5. Return the entire document's HTML code.
//
//6. If an exception occurs, display its stack trace and return "Some exception occurred".
//
//7. Run the application and be sure that all of the job postings are written to the jobPostings.html file.



//5. Use the copy of the template to add a separate HTML element to the page before the template object for each job posting. Return the entire page's HTML code.
//6. For each job posting, there should be a valid hyperlink with the job title (title) and URL to the posting (href).
//7. Each job posting must have a valid element with the "city" class.
//8. Each job posting must have a valid element with the "companyName" class.
//9. If an exception occurs, display its stack trace and return "Some exception occurred".