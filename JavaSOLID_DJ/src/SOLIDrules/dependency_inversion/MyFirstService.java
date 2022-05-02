package SOLIDrules.dependency_inversion;

public class MyFirstService implements MyService{
    @Override
    public void alertSomething(String s) {
        System.out.println(s);
        System.out.println("First Service is working!");
    }
}
