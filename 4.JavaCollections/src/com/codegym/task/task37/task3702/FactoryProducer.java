package com.codegym.task.task37.task3702;

import com.codegym.task.task37.task3702.female.FemaleFactory;
import com.codegym.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {

    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type) {

        if (type == HumanFactoryType.MALE) return new MaleFactory();
        if (type == HumanFactoryType.FEMALE) return new FemaleFactory();
        return null;

    }


}
