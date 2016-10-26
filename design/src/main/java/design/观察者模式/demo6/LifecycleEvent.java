package design.观察者模式.demo6;

import java.util.EventObject;

/**
 * fuquanemail@gmail.com 2016/10/26 16:18
 * description:
 * LifecycleEvent中定义了事件类别，不同的事件在具体观察者中可区别处理，更加灵活
 *
 */

public class LifecycleEvent extends EventObject {


    private final Object data;

    private final String type;


    public LifecycleEvent(Lifecycle lifecycle, String type, Object data) {

        super(lifecycle);
        this.type = type;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public Lifecycle getLifecycle() {

        return (Lifecycle) getSource();

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LifecycleEvent [");
        sb.append("data=").append(data);
        sb.append(", type='").append(type).append('\'');
        sb.append(']');
        return sb.toString();
    }
}
