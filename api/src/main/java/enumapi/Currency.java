package enumapi;

/**
 * 枚举
 * 1. 是java内置的一个类型。
 * 2. 枚举值是  static final 的，创建之后 不能修改。
 * 3. 可以用在 switch 中。
 * 4. 可以在枚举中定义 构造器、方法。
 */
public enum Currency {
    //PENNY, NICKLE, DIME, QUARTER;

    // 创建的时候 就指定枚举的值
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private int value;

    private Currency(int value) {
        this.value = value;
    }

    // 添加一个方法 获取枚举的 值
    public int getValue() {
        return value;
    }

    // In Java, Enum can override methods also. Let’s see an example of overriding toString()
    // method inside Enum in Java to provide a meaningful description for enums constants.

    @Override
    public String toString() {
        switch (this) {
            case PENNY:
                System.out.println("Penny: " + value);
                break;
            case NICKLE:
                System.out.println("Nickle: " + value);
                break;
            case DIME:
                System.out.println("Dime: " + value);
                break;
            case QUARTER:
                System.out.println("Quarter: " + value);
                break;
            default:
                return super.toString();
        }
        return
            super.toString();
    }

    /**
     * Java compiler automatically generates static values() method for every enum in java.
     * Values() method returns array of Enum constants in the same order they have listed in
     * Enum and you can use values() to iterate over values of Enum  in Java as shown in below example:
     */

    public static void printAll() {
        for (Currency coin : Currency.values()) {
            System.out.println("coin: " + coin);
        }

    }
}
