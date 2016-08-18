package refactor.chapter1.v1;

/**
 * fuquanemail@gmail.com 2016/8/15 12:02
 * description:
 */
public abstract class Price {

    abstract int getPriceCode();        //取得价格代号

    /**
     * 这个问题的第一部分是switch 语句。在另一个对象的属性（attribute）基础上运用switch 语句，并不是什么好主意。
     * 如果不得不使用，也应该在对象自己的数据上使用，而不是在别人的数据上使用。
     * <p/>
     * 所以这个方法 是从 Rental 移过来的
     *
     * @param daysRented
     * @return
     */
//    public double getCharge(int daysRented) {
//        double result = 0;
//
//        switch (getPriceCode()) {
//
//            case Movie.REGULAR:
//
//                result += 2;
//
//                if (daysRented > 2)
//
//                    result += (daysRented - 2) * 1.5;
//
//                break;
//
//            case Movie.NEW_RELEASE:
//
//                result += daysRented * 3;
//
//                break;
//
//            case Movie.CHILDRENS:
//
//                result += 1.5;
//
//                if (daysRented > 3)
//
//                    result += (daysRented - 3) * 1.5;
//
//                break;
//
//        }
//
//        return result;
//    }
    public abstract double getCharge(int daysRented);

    /**
     * 并在superclass 内留下一个已定义的函数，使它成为一种缺省行为
     * @param daysRented
     * @return
     */
    public int getFrequentRenterPoints(int daysRented) {

        return 1;

    }

}

class ChildrensPrice extends Price {

    int getPriceCode() {

        return Movie.CHILDRENS;

    }

    public double getCharge(int daysRented) {

        double result = 1.5;

        if (daysRented > 3)

            result += (daysRented - 3) * 1.5;

        return result;

    }


}

class NewReleasePrice extends Price {

    int getPriceCode() {

        return Movie.NEW_RELEASE;

    }

    public double getCharge(int daysRented) {

        return daysRented * 3;

    }

    public int getFrequentRenterPoints(int daysRented) {

        return (daysRented > 1) ? 2 : 1;

    }


}

class RegularPrice extends Price {

    int getPriceCode() {

        return Movie.REGULAR;

    }

    public double getCharge(int daysRented) {

        double result = 2;

        if (daysRented > 2)

            result += (daysRented - 2) * 1.5;

        return result;

    }


}



