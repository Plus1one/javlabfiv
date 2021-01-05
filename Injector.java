import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

class Injector<T> {
    private final Properties prop;

    Injector() throws IOException {
        prop = new Properties();
        prop.load(new FileInputStream(new File("src/prop.properties")));
    }

    T inject(T obj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class relationClass;
        Class className = obj.getClass();
        Field[] fields = className.getDeclaredFields();
        for (Field field: fields) {
            Annotation ann = field.getAnnotation(AutoInjectable.class);
            if (ann != null) {
                String[] type = ((field.getType()).toString()).split(" ");
                String implClassName = prop.getProperty(type[1], null);
                if (implClassName != null) {
                    relationClass = Class.forName(implClassName);
                    field.setAccessible(true);
                    field.set(obj, relationClass.newInstance());
                }
            }
        }
        return obj;
    }
}