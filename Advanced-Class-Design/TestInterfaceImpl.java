
class TestInterfaceImpl implements TestInterface {

    public void method4() {
        System.out.println("I'm method4");
    }

    public static void main(String args[]) {
        TestInterface.method2();

        TestInterfaceImpl i = new TestInterfaceImpl();
        i.method3();
    }
}