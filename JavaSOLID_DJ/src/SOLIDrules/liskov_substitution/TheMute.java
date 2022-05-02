package SOLIDrules.liskov_substitution;

public class TheMute extends Human{

    @Override
    public void say(){
        throw new RuntimeException("cant say");
    }

    public static void main(String[] args) {
        Human h = new TheMute();
        h.say();
    }
}
