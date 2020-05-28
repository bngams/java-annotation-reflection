import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class AnnotationRunner {

    public static void main(String[] args) {
        AnnotatedPOJO obj = new AnnotatedPOJO();
        Stream.of(obj.getClass().getMethods())
                .filter(method-> method.isAnnotationPresent(CanRun.class))
                .forEach(method-> invoke(method, obj));
    }

    private static void invoke(Method m, Object o) {
        try {
            m.invoke(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
