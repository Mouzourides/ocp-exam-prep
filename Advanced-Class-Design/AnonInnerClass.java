class AnonInnerClass {
    
    abstract class Animal {
        abstract void eat();
    };

    void eat() {
        // Implements abstract class. Needs a semi-colon on the end.
        // Basically a local inner class with no ref. Cant define static methods.
        Animal cat = new Animal() {
            void eat() {
                System.out.println("Eating cat food");
            }
        };

        Animal dog = new Animal() {
            void eat() {
                System.out.println("Eating dog food");
            }
        };

        cat.eat();
        dog.eat();
    } 
    
    public static void main(String[] args) {
        new AnonInnerClass().eat();
    }
}