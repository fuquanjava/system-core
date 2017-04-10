package enumapi;

/**
 * 常量存在的问题：
 *
 * 1. 不是类型安全的，比如下面的 CurrencyDenom 常量表示货币，只有 1，5，10，25，但是用常量表示，就可以用2，4等等来代替，无法校验类型。
 * 2. 缺乏一个有意义的输出的名字，比如打印 CurrencyDenom.PENNY 的结果是 1，没有实际的意义。
 * 3. 命名空间，访问 PENNY的值 必须是 CurrencyDenom.PENNY(虽然有静态导入）
 *
 *
 * 综上枚举就是解决这些问题的
 *
 */
public class CurrencyDenom {

    public static final int PENNY = 1;
    public static final int NICKLE = 5;
    public static final int DIME = 10;
    public static final int QUARTER = 25;

}



