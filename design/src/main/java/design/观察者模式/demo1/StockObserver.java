package design.观察者模式.demo1;

/**
 * Hello-World 2015/8/9 11:17
 * fuquanemail@gmail.com
 */
public class StockObserver {
    private String name;
    private MM mm ;
    public StockObserver(String name , MM mm ){
        this.name = name;
        this.mm = mm;
    }
    public void update(){
        System.out.println(mm.getAction());
    }

}
