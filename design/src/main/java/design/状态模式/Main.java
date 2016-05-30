package design.状态模式;

/**
 * Hello-World 2015/8/9 17:26
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for(int i=0;i<9;i++){
            vm.vote("u1","A");
        }
    }
}
