public enum FuturamaCharacters {
    // must have semi-colon on the end if there is anything other than the values
    BENDER("Bite my shiny metal ass") {
        public void sayHello() {
            System.out.println("What are you looking at?");
        }
        public void sayBye() {
            System.out.println("Later meatbag!");
        }
    },
    FRY("Pizza delivery for.... I. C. Wiener") {
        public void sayHello() {
            System.out.println("Hi, I'm Fry!");
        }
    },
    LEELA("Stop looking at my eye!") {
        public void sayHello() {
            System.out.println("Hey...");
        }
    },
    ZOIDBERG("Hooray! I'm useful!") {
        public void sayHello() {
            System.out.println("Why hello there!");
        }
    };

    // constructors must be private
    // constructor is called for each enum when first used, once.
    private FuturamaCharacters(String quote) {
        System.out.println(quote);
    }

    public void quote() {
        switch (this) {
        case BENDER:
            System.out.println("Bite my shiny metal ass");
            break;
        case LEELA:
            System.out.println("Stop looking at my eye!");
            break;
        case FRY:
            System.out.println("Pizza delivery for.... I. C. Wiener");
            break;
        case ZOIDBERG:
            System.out.println("Hooray! I'm useful!");
            break;
        }
    }

    // abstract methods mean each enum has to implement it
    public abstract void sayHello();

    // default method than can be overriden in enum constructor e.g. bender's enum
    public void sayBye() {
        System.out.println("Goodbye");
    }
}