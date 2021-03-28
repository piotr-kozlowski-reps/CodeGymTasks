package com.codegym.task.task28.task2810;

import com.codegym.task.task28.task2810.model.*;
import com.codegym.task.task28.task2810.view.HtmlView;
import com.codegym.task.task28.task2810.view.View;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Aggregator {
    
    public static void main(String[] args) {
        HtmlView view = new HtmlView();

        Strategy linkedInStrategy = new LinkedinStrategy();
        Strategy indeedStrategy = new IndeedStrategy();

        Provider linkedInProvider = new Provider(linkedInStrategy);
        Provider indeedProvider = new Provider(indeedStrategy);

        Model model = new Model(view, linkedInProvider, indeedProvider);

        Controller controller = new Controller(model);

        view.setController(controller);
        view.emulateCitySelection();
    }

}
