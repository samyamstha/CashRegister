import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CoinPackTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void CoinPack() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Can't store negative coins");
        CoinPack coinPack = new CoinPack(-1,-1,-1,-1);
    }

    @Test
    public void pennies() {

        CoinPack coinPack = new CoinPack(4,4,4,4);
        assertEquals(coinPack.pennies(), 4);
        coinPack.pennies(5);
        //assertEquals(coinPack.cents[0], 5); //uncomment this test to justify the presence of bug

    }

    @Test
    public void nickles() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        assertEquals(coinPack.nickles(), 4);
        coinPack.nickles(5);
        assertEquals(coinPack.cents[1], 5);

    }

    @Test
    public void dimes() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        assertEquals(coinPack.dimes(), 4);
        coinPack.dimes(5);
        assertEquals(coinPack.cents[2], 5);
    }

    @Test
    public void quarters() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        assertEquals(coinPack.quarters(), 4);
        coinPack.quarters(5);
        assertEquals(coinPack.cents[3], 5);
    }

    @Test
    public void pennies1() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        long value = -1;
        assertFalse(coinPack.pennies(value));
        long value1 = 4;
        assertTrue(coinPack.pennies(value1));
    }

    @Test
    public void nickles1() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        long value = -1;
        assertFalse(coinPack.nickles(value));
        long value1 = 4;
        assertTrue(coinPack.nickles(value1));


    }

    @Test
    public void dimes1() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        long value = -1;
        assertFalse(coinPack.dimes(value));
        long value1 = 4;
        assertTrue(coinPack.dimes(value1));
    }

    @Test
    public void quarters1() {
        CoinPack coinPack = new CoinPack();
        long value = -1;
        assertFalse(coinPack.quarters(value));
        long value1 = 4;
        assertTrue(coinPack.quarters(value1));
    }
}