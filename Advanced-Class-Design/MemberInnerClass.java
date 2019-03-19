class MemberInnerClass {
    private String name = "Nik";
    
    void changeName() {
        name = "John";
    }

    void sayHello() {
        // in non static method you can just instantiate as normal
        Inner inner = new Inner();
        inner.sayHello();
    }

    void getInnerClassProperty() {
        Inner inner = new Inner();
        // can access private properties on inner class
        System.out.println(inner.name);
    }
    public static void main(String args[]) {
        MemberInnerClass outer = new MemberInnerClass();
        outer.changeName();
        // this just looks wrong, it works but its so wrong
        // You need a ref from a static method
        outer.new Inner().sayHello();
        outer.getInnerClassProperty();
    }

    // cant define static methods
    class Inner {
        private String name = "Charlie";
        private void sayHello() {
            // can access private methods
            // you can access out class properties via ClassName.this.property
            System.out.println("Hello " + MemberInnerClass.this.name);
        }
    }
}