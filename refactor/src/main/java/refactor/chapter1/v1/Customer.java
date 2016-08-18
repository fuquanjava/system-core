package refactor.chapter1.v1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * fuquanemail@gmail.com 2016/8/15 10:44
 * description:用来表示顾客。就像其他classes 一样，它也拥有数据和相应的访问函数
 */
public class Customer {
    private String _name;                        //姓名

    private Vector _rentals = new Vector();        //租借记。

    public Customer(String name) {

        _name = name;

    }

    public void addRental(Rental arg) {

        _rentals.addElement(arg);

    }

    public String getName() {

        return _name;

    }

    public String statement() {

        //double totalAmount = 0;        //总消费金。

        //int frequentRenterPoints = 0;        //常客积点

        Enumeration rentals = _rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {

            Rental aRental = (Rental) rentals.nextElement();        //取得一笔租借记。

            /**
             * 去除临时变量，导致下面的结果计算两次。
             */
            // double thisAmount = amountFor(aRental);


            /**
             * 用下面的方法替换
             */
            // frequentRenterPoints += aRental.getFrequentRenterPoints();

            /**
             * 我喜欢尽量除去这一类临时变量。临时变量往往形成问题，它们会导致大量参数被传来传去，而其实完全没有这种必要。
             * 你很容易失去它们的踪迹，尤其在长长的函数之中更是如此。当然我这么做也需付出性能上的代价，例如本例的费用就被计算了两次。
             * 但是这很容易在Rental class 中被优化。而且如果代码有合理的组织和管理，优化会有很好的效果。
             * 我将在p.69的「重构与性能」一节详谈这个问题。
             *
             */
            //show figures for this rental（显示此笔租借记录）

            result += "\t" + aRental.getMovie().getTitle() + "\t" +

                    String.valueOf(amountFor(aRental)) + "\n";


            /**
             * 用下面的方法替换
             */
            // totalAmount += amountFor(aRental);


        }

        //add footer lines（结尾打印）

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";

        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +

                " frequent renter points";

        return result;


    }

    /**
     * 新增加的功能
     * @return
     */
    public String htmlStatement() {

        Enumeration rentals = _rentals.elements();

        String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            //show figures for each rental

            result += each.getMovie().getTitle()+ ": " +

                    String.valueOf(each.getCharge()) + "<BR>\n";

        }

        //add footer lines

        result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";

        result += "On this rental you earned <EM>" +

                String.valueOf(getTotalFrequentRenterPoints()) +

                "</EM> frequent renter points<P>";

        return result;

    }



    /**
     * 这次重构存在另一个问题，那就是性能。原本代码只执行while 循环一次，新版本要执行三次。
     * 如果循环耗时很多，就可能大大降低程序的性能。
     * 单单为了这个原因，许多程序员就不愿进行这个重构动作。
     * 但是请注意我的用词：如果和可能。除非我进行评测（profile），
     * 否则我无法确定循环的执行时间，也无法知道这个循环是否被经常使用以至于影响系统的整体性能。
     *
     * 重构时你不必担心这些，优化时你才需要担心它们，但那时候你已处于一个比较有利的位置，有更多选择可以完成有效优化（见p.69的讨论）。
     *
     *
     * @return
     */
    //译注：此即所谓query method

    private double getTotalCharge() {

        double result = 0;

        Enumeration rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            result += each.getCharge();

        }

        return result;

    }


    //译注：此即所谓query method

    private int getTotalFrequentRenterPoints(){

        int result = 0;

        Enumeration rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            result += each.getFrequentRenterPoints();

        }

        return result;

    }


    private double amountFor(Rental aRental) {

        return aRental.getCharge();

    }


}
