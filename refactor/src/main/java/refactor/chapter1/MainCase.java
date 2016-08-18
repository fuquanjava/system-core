package refactor.chapter1;

import refactor.chapter1.v1.Customer;
import refactor.chapter1.v1.Movie;
import refactor.chapter1.v1.Rental;

/**
 * fuquanemail@gmail.com 2016/8/15 10:46
 * description:
 */
public class MainCase {
    public static void main(String[] args) {
        v1();
    }

    public static void v1(){
        Movie movie = new Movie("大电影",1);
        Rental rental = new Rental(movie,10);

        Customer customer = new Customer("张三丰");

        customer.addRental(rental);
        customer.addRental(rental);

        String result = customer.statement();

        System.err.println(result);

        result = customer.htmlStatement();

        System.err.println(result);
    }

}
