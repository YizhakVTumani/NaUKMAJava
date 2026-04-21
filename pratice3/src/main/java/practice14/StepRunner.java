package practice14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StepRunner {
    public static void run(Object target) {
        Class<?> clazz = target.getClass();
        List<Method> stepMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Step.class)) {
                if (method.getReturnType() != void.class || method.getParameterCount() != 0) {
                    throw new StepExecutionException("Invalid step signature: " + method.getName());
                }
                stepMethods.add(method);
            }
        }

        stepMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Step.class).order()));

        for (Method method : stepMethods) {
            try {
                method.setAccessible(true);
                method.invoke(target);
            } catch (InvocationTargetException e) {
                throw new StepExecutionException("Step failed during execution: " + method.getName(), e.getCause());
            } catch (Exception e) {
                throw new StepExecutionException("Reflection access error on: " + method.getName(), e);
            }
        }
    }
}