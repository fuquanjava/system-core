package disruptor;


import com.lmax.disruptor.EventHandler;
import disruptor.event.LongEvent;

/**
 * fuquanemail@gmail.com
 */
public class LongEventHandler  implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
