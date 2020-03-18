package designpattern.gof_flyweight.sample01;

public class Ramen implements INoodle {

    private final String flavor;


    public Ramen(String flavor) {
        this.flavor = flavor;
        System.out.println("Noodle is created!" + flavor);
    }

    public String getFlavor() {
        return this.flavor;
    }

    public void serveNoodle(NoodleContext noodleContext) {
        System.out.println("Serving" + flavor + " to table " + noodleContext.getTable());
    }

}
