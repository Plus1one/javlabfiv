import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        SomeBean sb = new Injector<SomeBean>().inject(new SomeBean());
        sb.foo();
    }
}