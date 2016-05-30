package design.状态模式.state;

import design.状态模式.VoteManager;
import design.状态模式.VoteState;

/**
 * Hello-World 2015/8/9 17:21
 * fuquanemail@gmail.com
 */
public class NormalVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
//正常投票，记录到投票记录中
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
    }
}
