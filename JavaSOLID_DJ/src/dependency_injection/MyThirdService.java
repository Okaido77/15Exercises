package dependency_injection;

public class MyThirdService implements MyService{
    @Override
    public void alertSomething(String s) {
        System.out.println("Third Service");
    }
}
