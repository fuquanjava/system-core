package design.观察者模式.demo5;
/**
 * fuquanemail@gmail.com 2016/3/10 11:52
 * description:
 * 1.0.0
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(78, 90, 29.2f);

    }
}
