package practice5;

abstract class ReportGenerator {
    final void generator(){
        text();
        sign();
    }

    abstract void text();
    abstract void sign();

    void main() {
        generator();
    }
}
class DailyRep extends ReportGenerator{
    @Override
    public void text(){
        System.out.println("Text of the report...");
    }
    @Override
    public void sign(){
        System.out.println("Signed by Boss...");
    }
}
