import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    static final SILab2 test = new SILab2();

    static ArrayList<Time> createlist(Time... times){
        return new ArrayList<>(Arrays.asList(times));
    }

    static ArrayList<Integer> createlist_int(Integer... ints){
        return new ArrayList<>(Arrays.asList(ints));
    }

    @Test
    void Multiple_condition(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,() -> test.function(createlist
                (new Time(-1,1,1))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class,() -> test.function(createlist
                (new Time(25,1,1))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class,() -> test.function(createlist
                (new Time(13,420,1))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class,() -> test.function(createlist
                (new Time(13,45,-69))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class,() -> test.function(createlist
                (new Time(24,0,90))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        assertEquals(createlist_int(33021,86400),test.function(createlist
                (new Time(9,10,21), new Time(24,0,0))));
    }

    @Test
    void Every_branch() {
        RuntimeException ex;
        assertEquals(createlist_int(48015), test.function(createlist
                (new Time(13, 20, 15))));

        assertEquals(createlist_int(49501), test.function(createlist
                (new Time(13, 45, 1))));

        ex = assertThrows(RuntimeException.class, () -> test.function(createlist
                (new Time(13, -15, 1))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> test.function(createlist
                (new Time(13, 45, 69))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> test.function(createlist
                (new Time(24, 100, 21))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }
}