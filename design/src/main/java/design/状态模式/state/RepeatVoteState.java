package design.状态模式.state;

import design.状态模式.VoteManager;
import design.状态模式.VoteState;

/**
 * Hello-World 2015/8/9 17:23
 * fuquanemail@gmail.com
 */
public class RepeatVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
//重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }
}
