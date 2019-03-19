class StaticAccess {

    // Static stuff
    static int staticNum = 10;

    static void staticPrintStuff() {
        System.out.println("Static Print stuff!");
    }

    // Non static stuff
    int num = 1;

    public void printStuff() {
        System.out.println("Non static print stuff!");

        // You can access static stuff from regular method
        staticPrintStuff();
        System.out.println(staticNum);
    }

    public static void main(String args[]) {
        // Static methods can access static fields and methods
        System.out.println(staticNum);
        staticPrintStuff();

        // Can access them normally or via static ref
        StaticAccess.staticPrintStuff();

        // Static methods can't access not static stuff
        // printStuff(); doesn't work
        // System.out.println(num); doesn't work
        // ...unless you have a ref to object
        StaticAccess sa = new StaticAccess();
        System.out.println(sa.num);
        sa.printStuff();
    }
}