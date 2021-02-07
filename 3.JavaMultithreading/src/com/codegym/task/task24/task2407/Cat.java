package com.codegym.task.task24.task2407;

/*
At times, you'll need to cast a class to some interface (CanSpeak, in this case)
that isn't implemented in the current class
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * This is a way to adapt to a different interface (CanSpeak)
     * Inside the toCanSpeak method, create a CatPet class that implements the CanSpeak interface
     * The method's logic is this:
     * If i < 1, then display a message indicating that the cat is sleeping. For example, "Oscar is sleeping."
     * Otherwise, display: "<cat name> says meow!". For example, i=3, "Oscar says meooow!"
     * <p/>
     * <b>Example output:</b>
     * Smokey is sleeping.
     * Oscar says meoow!
     * Kitty says meooooow!
     * The mouse squeaks.
     * Tom says meow!
     * <p/>
     * @param i the number of o's to use in "meow"
     * @return an instance of the CatPet class
     */
    public CanSpeak toCanSpeak(final int i) {

        class CanPet implements CanSpeak{

            @Override
            public String speak() {

                if (i < 1){
                    return name + " is sleeping.";
                } else {

                    StringBuilder result = new StringBuilder();
                    result.append(name).append(" says me");
                    for (int k = 0; k < i; k++){
                        result.append("o");
                    }
                    result.append("w!");

                    return result.toString();
                }
            }
        }

        return new CanPet();
    }
}

//Implementing an interface using a local class
//In the Cat class, implement the toCanSpeak method's logic, which is described in a Javadoc.
//
//
//Requirements:
//1. The Cat class must implement a public toCanSpeak method with one int parameter.
//2. The toCanSpeak method must return a CanSpeak object.
//3. If the passed argument is less than 1, the speak() method must return a string formatted as follows: "<name> is sleeping.", where <name> is the name of the current cat.
//4. If the passed argument is greater than or equal to 1, the speak() method must return a string formatted as follows: "<name> says meooow!", where <name> is the name of the current cat, and the number of o's to use in "meow" is equal to the passed parameter.
//5. The program should display data on the screen.