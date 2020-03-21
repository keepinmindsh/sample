package lines.customannotations.sample;

import java.lang.reflect.InvocationTargetException;

public class AnnotationDemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        MyContextContainer lineDemo = new MyContextContainer();

        LineObject lineObject = lineDemo.get(LineObject.class);

        System.out.println(lineObject.getName());
        System.out.println(lineObject.getDefaultValue());
        System.out.println(lineObject.getInvalidType());
    }
}
