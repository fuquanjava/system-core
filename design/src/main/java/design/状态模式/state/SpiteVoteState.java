package design.状态模式.state;

import design.状态模式.VoteManager;
import design.状态模式.VoteState;

/**
 * Hello-World 2015/8/9 17:23
 * fuquanemail@gmail.com
 */
public class SpiteVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 恶意投票，取消用户的投票资格，并取消投票记录
        String str = voteManager.getMapVote().get(user);
        if (str != null) {
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
    }
}
