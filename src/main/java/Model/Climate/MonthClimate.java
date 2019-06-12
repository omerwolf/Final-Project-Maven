package Model.Climate;

/**
 * represents a month climate (the month id, amount of rain and temp).
 * read from an excel every time, not inserted for the database.
 */
public class MonthClimate {
    int monthNum;
    int rain;
    int temp;

    /**
     * creates a monthClimate class.
     * @param monthNum - the month's id(values between 1-12).
     * @param rain - the mean amount of rain in this month.
     * @param temp - the mean temperature in this month.
     */
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

    /**
     * overrides toString method in order to print the climate
     * month field names and values.
     * @return climate's field names and values.
     */
    @Override
    public String toString() {
        return "MonthClimate{" +
                "monthNum=" + monthNum +
                ", rain=" + rain +
                ", temp=" + temp +
                '}';
    }
}
