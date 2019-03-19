interface TestInterface {

    // can only have private regular methods, any more public access will fail
    private void method1() {
        System.out.println("I'm method1");
    }

    // public void method1() {}; -- doesn't work

    // static methods can have body
    static void method2() {
        System.out.println("I'm method2");
    }

    // default methods can have body, default methods are public by default and
    // can't be less accessible
    default void method3() {
        method1();
        System.out.println("I'm method3");
    }

    // private default void method3() {} -- fails

    // methods eithout body are public and abstract by default
    void method4();

    // methods without body can't be static or default
    // default void method1(); -- doesn't work
    // static void method1(); -- doesn't work
}