package lines.customannotations.sample;

import lines.customannotations.custom.StringInjector;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyContextContainer {

    public MyContextContainer() {
    }

    private <T> T invokeAnnnotations(T instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        for(Field field : fields){
            StringInjector stringInjector = field.getAnnotation(StringInjector.class);
            if( stringInjector != null && field.getType() == String.class){
                field.setAccessible(true);
                field.set(instance , stringInjector.value());
            }
        }
        return instance;
    }

    public <T> T get(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T instance = (T) clazz.getDeclaredConstructor().newInstance();
        instance = invokeAnnnotations(instance);
        return instance;
    }
}
