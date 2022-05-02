package dependency_injection;

public class MyFirstService implements MyService{
    @Override
    public void alertSomething(String s) {
        System.out.println(s);
        System.out.println("First Service is working!");
    }
}

