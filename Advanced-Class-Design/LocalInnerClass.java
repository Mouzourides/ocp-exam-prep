class LocalInnerClass {

    void outerMethod() {
        // Inner inner = new Inner();
        // inner.thisIsWrong();
        // Doesn't work
    }

    void innerClassMethod() {
        // scope only within this method
        // have access to all fields and methods of outer class
        // can't be static or have access modifiers
        // Does not have access to LOCAL variables effecively final
        String name = "Nikolas";
        int age = 21; // not effectively final
        age++;

        // cant define static methods
        class Inner {
            void thisIsWrong() {
                System.out.println("This feels wrong");
            }

            private void printOuterName() {
                System.out.println(name);
            }

            private void printOuterAge() {
                // System.out.println(age); fails to compile as age not effectivly final
            }
        }

        Inner inner = new Inner();
        inner.thisIsWrong();
        inner.printOuterName();
        inner.printOuterAge();
    }

    public static void main(String args[]) {
        LocalInnerClass outer = new LocalInnerClass();
        outer.innerClassMethod();
    }
}