package Model.Climate;

public class MonthClimate {
    int monthNum;
    int rain;
    int temp;

    public MonthClimate(int monthNum, int rain, int temp) {
        this.monthNum = monthNum;
        this.rain = rain;
        this.temp = temp;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(int monthNum) {
        this.monthNum = monthNum;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "MonthClimate{" +
                "monthNum=" + monthNum +
                ", rain=" + rain +
                ", temp=" + temp +
                '}';
    }
}
