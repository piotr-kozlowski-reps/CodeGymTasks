package com.codegym.task.task37.task3702.female;

import com.codegym.task.task37.task3702.AbstractFactory;
import com.codegym.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age) {

        if (age > 0 && age <= 12) return new KidGirl();
        else if (age > 12 && age <= 19) return new TeenGirl();
        else if (age > 19) return new Woman();
        return null;

    }

}
