package enumapi;

/**
 *
 */
public interface Named {

    String name();

    int order();

    enum Planets implements Named {
        Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune;

        // name() is implemented automagically.

        // ordinal: 枚举元素声明的位置
        @Override
        public int order() { return ordinal()+1; }
    }

}
