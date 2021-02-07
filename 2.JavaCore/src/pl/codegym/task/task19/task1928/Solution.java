package pl.codegym.task.task19.task1928;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* 
Napraw błąd. Klasy i interfejsy
*/

public class Solution {

    {
        System.out.println("To jest klasa Solution");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1]);
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("To jest klasa A");
        }
    }

    class B implements Example {
        {
            System.out.println("To jest klasa B");
        }
    }

    class C extends A {
        {
            System.out.println("To jest klasa C");
        }
    }
}
