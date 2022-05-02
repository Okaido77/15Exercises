package dependency_injection;
import javax.inject.Inject;

public class MyApp {
//    @Inject
//    public MyService _myService;

    private MyFirstService mfs = new MyFirstService();
    private MySecondService mss = new MySecondService();
    private MyThirdService mts = new MyThirdService();
    public MyFirstService getMfs() {
        return mfs;
    }

    public MySecondService getMss() {
        return mss;
    }

    public MyThirdService getMts() {
        return mts;
    }

    public void setMts(MyThirdService mts) {
        this.mts = mts;
    }

    public MyApp() {
//        this._myService = _myService;
        mfs.alertSomething("Application is running!");
    }

    public static void main(String[] args) {

        MyApp myApp = new MyApp();
        myApp.getMfs().alertSomething("App runs");
        myApp.getMss().alertSomething("app runs second times");
        myApp.getMts().alertSomething("App rúns third times");
    }
}


