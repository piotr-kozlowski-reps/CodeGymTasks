package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.view.View;
import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Model {

    //fields
    View view;
    Provider[] providers;

    //constr
    public Model(View view, Provider...providers) throws IllegalArgumentException{
        this.view = view;
        this.providers = providers;
        if (providers == null || view == null || providers.length == 0) throw new IllegalArgumentException();
    }

    //
    public void selectCity(String city) {
        List<JobPosting> jobPostingList = new ArrayList<>();

        for (Provider specificProvider : providers) {
            jobPostingList.addAll(specificProvider.getJavaJobPostings(city));
        }

        view.update(jobPostingList);
    }
}