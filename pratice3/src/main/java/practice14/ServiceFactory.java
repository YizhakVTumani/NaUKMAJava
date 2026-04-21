package practice14;

public class ServiceFactory {
    public static Object create(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate service: " + className, e);
        }
    }
}
