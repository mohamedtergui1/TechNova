package org.example.model;

public class Weather {
    private float temp;
    private float humidity;
    private float pressure;
    private float windSpeed;
    private float windDirection;
    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setWindDirection(float windDirection) {
        this.windDirection = windDirection;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }
}
