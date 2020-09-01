package basic.Abstract;

import java.io.IOException;

public class ATestClass {
    public static void main(String[] argv) {
        new ATestClass().test();
    }

    private void test() {
        try {
            Person person = new Person("John", -10);
        } catch (IOException e) {
            System.out.println("Exception catched");
        } finally {
            System.out.println("execute finally block");
        }
    }

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) throws IOException {
            if (age < 0)
                throw new IllegalParamException("Invalid input age : " + age);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public class IllegalParamException extends RuntimeException {
        public IllegalParamException(String msg) {
            super(msg);
        }
    }


}

