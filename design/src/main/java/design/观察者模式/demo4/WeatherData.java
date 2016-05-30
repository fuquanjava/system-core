package design.观察者模式.demo4;

import java.util.ArrayList;
import java.util.List;

/**
 * fuquanemail@gmail.com 2016/3/10 11:43
 * description:
 * 1.0.0
 */
public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temp;

    private float humidity;

    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void measureUpdate() {
        notifyObserver();
    }

    /**
     * 模拟数据
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void setMeasures(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measureUpdate();

    }
}
