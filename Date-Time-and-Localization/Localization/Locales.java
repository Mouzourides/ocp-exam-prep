import java.util.Locale;

class Locales {
    public static void main(String stuff[]) {
        // Get YOUR locale
        // Country is always capital and language is always lowercase seperated by an
        // underscore e.g. en_GB
        // You can have a language without a country but not a country without a
        // language
        // FORMAT: language_COUNTRY
        System.out.println(Locale.getDefault());

        // Override the locale
        Locale.setDefault(Locale.JAPANESE);
        System.out.println(Locale.getDefault());

        // Creating a local
        // Case doesn't matter only when constructing a new locale but its good
        // convention to follow format it as it will be formatted after construction.
        Locale newLocale = new Locale("HI", "IN");
        Locale newLocale2 = new Locale("In", "hi");

        // order of country or language doesn't matter but case does
        System.out.println(newLocale + ", " + newLocale2);

        // You can use a builder
        Locale locale = new Locale.Builder().setLanguage("gr").setRegion("GR").build();
        System.out.println(locale);

        // There are a few consts... BUT NOT GREEK
        System.out.println(Locale.JAPAN);
    }
}