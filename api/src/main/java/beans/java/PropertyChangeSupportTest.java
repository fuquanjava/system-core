package beans.java;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * fuquanemail@gmail.com 2016/6/20 10:32
 * description: PropertyChangeSupport 是一个监听器模式 体现.
 *
 * 使用这个类管理监听器的好处是，它是线程安全的。如果使用一个循环体来set Bean的属性，则这个类可以保证所有监听器执行触发事件的有序。
 */
public class PropertyChangeSupportTest {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private String value;

    public void setValue(String newValue) {
        String oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("value", oldValue, newValue);
    }

    public String getValue() {
        return value;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("PropertyChangeSupportTest [");
        sb.append("value='").append(value).append('\'');
        sb.append(']');
        return sb.toString();
    }

    public static class MyPropertyChangeListener implements PropertyChangeListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Object newValue = evt.getNewValue();
            Object oldValue = evt.getOldValue();
            String propertyName = evt.getPropertyName();
            System.err.println("newValue:"+newValue);
            System.err.println("oldValue:"+oldValue);
            System.err.println("propertyName:"+propertyName);
        }
    }

    public static void main(String[] args) {
        PropertyChangeSupportTest supportTest = new PropertyChangeSupportTest();
        supportTest.setValue("123");

        supportTest.addPropertyChangeListener(new MyPropertyChangeListener());

        supportTest.setValue("abc");
        System.err.println(supportTest);


    }
}
