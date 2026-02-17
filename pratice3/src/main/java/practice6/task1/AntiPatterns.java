package practice6.task1;

public class AntiPatterns {
    // God Object
    //робить та знає все одночасно один клас
    static class GodObject {
        void doEverything() {
        }
    }
    // Spaghetti code
    //забагато іф-елсів та флагів, важко прослідкувати логіку
    static void spaghetti(boolean flag, boolean otherFlag) {
        if (flag) {
            if (otherFlag) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        } else {
            System.out.println("C");
        }
    }
    // Long Method
    //метод можна розбити на два менших методи (два різні фори в методи)
    static void longMethod() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        for (int i = 0; i < 100; i++) {
            sum += i * i;
        }
        System.out.println(sum);
    }
    //Primitive obsession
    // Краще створити новий обʼєкт не використовуючи примітивні типи
    static class User {
        String email;
        String phone;
    }
}

