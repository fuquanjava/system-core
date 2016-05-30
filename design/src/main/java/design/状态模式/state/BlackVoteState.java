package design.状态模式.state;

import design.状态模式.VoteManager;
import design.状态模式.VoteState;

/**
 * Hello-World 2015/8/9 17:23
 * fuquanemail@gmail.com
 */
public class BlackVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
