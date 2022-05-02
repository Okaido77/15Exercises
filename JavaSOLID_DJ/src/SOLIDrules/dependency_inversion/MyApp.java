package SOLIDrules.dependency_inversion;

import java.lang.annotation.Inherited;
public class MyApp {

//    public MyFirstService _myService;
//    instead of declare a low-level module as class above
//    we create an interface below
    public MyService _myService;

    public MyApp(MyService _myService) {
        this._myService = _myService;
        _myService.alertSomething("Application is running!");
    }

    public static void main(String[] args) {
        MyApp ma = new MyApp(new MyFirstService());

    }
}
