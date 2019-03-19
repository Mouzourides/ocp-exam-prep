class StaticNestedClass {
    // A static nested class is a static class at member level

    static class Inner {
        void sayHello() {
            System.out.println("Hello!");
        }
    }

    void sayHello() {
        Inner inner = new Inner();
        inner.sayHello();
    }

    public static void main(String[] args) {
        // Can instanciate normally in static or non-static method
        Inner inner = new Inner();
        inner.sayHello();

        StaticNestedClass outer = new StaticNestedClass();
        outer.sayHello();
    }
}