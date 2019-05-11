package ModelTests;

import Model.Climate.ERClimate;
import Model.Climate.MonthClimate;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;

public class ClimateTest {
    private ERClimate climate;

    @Before
    public void init(){
        climate = new ERClimate();
    }

    @Test
    public void test(){
        //Check that an list isn't null
        assertNotNull(climate.getMonthClimateList());

        MonthClimate january = this.climate.getMonth(3);
        assertEquals(january.getRain(), 100);
        assertEquals(january.getTemp(), 17);

        MonthClimate march = this.climate.getMonth(3);
        assertEquals(march.getRain(), 100);
        assertEquals(march.getTemp(), 17);

        MonthClimate june = this.climate.getMonth(6);
        assertEquals(june.getRain(), 0);
        assertEquals(june.getTemp(), 27);

        MonthClimate december = this.climate.getMonth(12);
        assertEquals(december.getRain(), 170);
        assertEquals(december.getTemp(), 10);
    }


}
