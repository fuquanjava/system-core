package design.观察者模式.demo5;

import design.观察者模式.demo4.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * fuquanemail@gmail.com 2016/3/10 12:07
 * description:
 * 1.0.0
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
