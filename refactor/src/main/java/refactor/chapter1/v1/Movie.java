package refactor.chapter1.v1;


/**
 * fuquanemail@gmail.com 2016/8/15 10:42
 * description:影片
 */
public class Movie {
    public static final int CHILDRENS = 2;

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;


    private String _title;        //名称

    /**
     * 这意味我必须在Movie class 内保存一个Price 对象，而不再是保存一个_priceCode 变量。此外我还需要修改访问函数
     *
     */
    //private int _priceCode;        //价格（代号）


    private Price _price;


    public Movie(String title, int priceCode) {

        _title = title;

        setPriceCode(priceCode);

    }


    public int getPriceCode() {

        return _price.getPriceCode();

    }


    public void setPriceCode(int arg) {

        switch (arg) {

            case REGULAR:

                _price = new RegularPrice();

                break;

            case CHILDRENS:

                _price = new ChildrensPrice();

                break;

            case NEW_RELEASE:

                _price = new NewReleasePrice();

                break;

            default:

                throw new IllegalArgumentException("Incorrect Price Code");

        }

    }


    public String getTitle() {

        return _title;

    }

    public  double getCharge(int daysRented) {

        return _price.getCharge(daysRented);

    }


    public int getFrequentRenterPoints(int daysRented) {
//        if ((getPriceCode() == NEW_RELEASE) && daysRented > 1)
//
//            return 2;
//
//        else
//
//            return 1;

        return _price.getFrequentRenterPoints(daysRented);

    }
}
