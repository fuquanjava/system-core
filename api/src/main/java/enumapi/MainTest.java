package enumapi;

import java.util.Arrays;

import enumapi.Named.Planets;

public class MainTest {

    public static void main(String[] args) {
        Currency currency = Currency.DIME;

        System.err.println(currency);
        //System.err.println(currency.getValue());
        //switchTest(currency);

        // 枚举在java中是常量，所以可以用 == 比较。
        System.err.println(currency == Currency.DIME);

        enumValues();


        NamedTest();
    }

    public static void NamedTest(){
        System.out.println("Planets.Earth.order:"+Planets.Earth.order());
        System.out.println("Planets.Earth.name:"+Planets.Earth.name());

    }
    public static void switchTest(Currency currency) {
        switch (currency) {
            case PENNY:
                System.out.println("Penny coin");
                break;
            case NICKLE:
                System.out.println("Nickle coin");
                break;
            case DIME:
                System.out.println("Dime coin");
                break;
            case QUARTER:
                System.out.println("Quarter coin");
                break;

            default:
                throw new NullPointerException("switchTest e");
        }
    }

    public static void enumValues() {
        System.err.println(Arrays.toString(Currency.values()));

        Currency.printAll();
    }
}
