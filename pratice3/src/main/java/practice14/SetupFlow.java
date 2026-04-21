package practice14;

public class SetupFlow {
    @Step(order = 2)
    private void loadConfigurations() {
        System.out.println("1: private meth");
    }

    @Step(order = 1)
    public void initializeSystem() {
        System.out.println("Exe1: init");
    }

    @Step(order = 3)
    private void failProcess() {
        System.out.println("Exe3: failure");
        throw new IllegalStateException("eexception");
    }
}