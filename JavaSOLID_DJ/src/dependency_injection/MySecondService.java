package dependency_injection;

public class MySecondService implements MyService{
    @Override
    public void alertSomething(String s) {
        System.out.println("Second service");
    }
}
