package refactor.chapter1.v1;

/**
 * fuquanemail@gmail.com 2016/8/15 10:43
 * description:租赁,表示「某个顾客租了一部影片」。
 */
public class Rental {
    Movie _movie;        //影片

    private int _daysRented;        //租期

    public Rental(Movie movie, int daysRented) {

        _movie = movie;

        _daysRented = daysRented;

    }

    public int getDaysRented() {

        return _daysRented;

    }

    public Movie getMovie() {

        return _movie;

    }

    public double getCharge() {

        return _movie.getCharge(_daysRented);

    }

    public  int getFrequentRenterPoints() {

        return _movie.getFrequentRenterPoints(_daysRented);

    }



    /**
     * 这个问题的第一部分是switch 语句。在另一个对象的属性（attribute）基础上运用switch 语句，并不是什么好主意。
     * 如果不得不使用，也应该在对象自己的数据上使用，而不是在别人的数据上使用。
     */

    /*public double getCharge() {
        double result = 0;
        //determine amounts for aRental line
        switch (getMovie().getPriceCode()) {        //取得影片出租价格

            case Movie.REGULAR:                        //普通片

                result += 2;

                if (getDaysRented() > 2)

                    result += (getDaysRented() - 2) * 1.5;

                break;

            case Movie.NEW_RELEASE:                //新片

                result += getDaysRented() * 3;

                break;

            case Movie.CHILDRENS:                //儿童。

                result += 1.5;

                if (getDaysRented() > 3)

                    result += (getDaysRented() - 3) * 1.5;

                break;


        }
        return result;
    }*/
}
