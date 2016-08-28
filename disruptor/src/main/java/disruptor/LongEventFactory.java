package disruptor;

import com.lmax.disruptor.EventFactory;
import disruptor.event.LongEvent;

/**
 * fuquanemail@gmail.com
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
