import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BillPackTest {

    //BillPack billpack = new BillPack();
   // BillPack billPack1 = new BillPack(1,2,3,4,5,6);



    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testBillPack() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Can't store negative bills");
        BillPack billPack1 = new BillPack(-1,2,3,4,5,6);

    }


    @Test
    public void ones() {
        BillPack billPack1 = new BillPack(1,2,3,4,5,6);
        BillPack billpack = new BillPack();
        //assertEquals(billpack.ones(2), billpack.bills[0]);
        assertTrue(billpack.ones(0));
        assertTrue(billpack.ones(2));
        assertFalse(billpack.ones(-2));
        billpack.ones(5);
        assertEquals(billpack.bills[0], 5);
    }

    @Test
    public void fives() {
        BillPack billpack = new BillPack();
        assertTrue(billpack.fives(0));
        assertTrue(billpack.fives(2));
        assertFalse(billpack.fives(-2));

        billpack.fives(5);
        assertEquals(billpack.bills[1], 5);
    }

    @Test
    public void tens() {
        BillPack billpack = new BillPack();
        assertTrue(billpack.tens(0));
        assertTrue(billpack.tens(2));
        assertFalse(billpack.tens(-2));

        billpack.tens(5);
        assertEquals(billpack.bills[2], 5);
    }

    @Test
    public void twenties() {
        BillPack billpack = new BillPack();
        assertTrue(billpack.twenties(0));
        assertTrue(billpack.twenties(2));
        assertFalse(billpack.twenties(-2));

        billpack.twenties(5);
        assertEquals(billpack.bills[3], 5);
    }

    @Test
    public void fifties() {
        BillPack billpack = new BillPack();
        assertTrue(billpack.fifties(0));
        assertTrue(billpack.fifties(2));
        assertFalse(billpack.fifties(-2));

        billpack.fifties(5);
        assertEquals(billpack.bills[4], 5);
    }

    @Test
    public void hundreds() {
        BillPack billpack = new BillPack();
        assertTrue(billpack.hundreds(0));
        assertTrue(billpack.hundreds(2));
        assertFalse(billpack.hundreds(-2));

        billpack.hundreds(5);
        assertEquals(billpack.bills[5], 5);
    }

    @Test
    public void ones1() {
        BillPack billpack = new BillPack();

        assertEquals(billpack.ones(), 0);
    }

    @Test
    public void fives1() {
        BillPack billpack = new BillPack();
        billpack.bills[1] = 2;
        assertEquals(billpack.fives(), 2);
    }

    @Test
    public void tens1() {
        BillPack billpack = new BillPack();
        billpack.bills[2] = 2;
        assertEquals(billpack.tens(), 2);
    }

    @Test
    public void twenties1() {
        BillPack billpack = new BillPack();
        billpack.bills[3] = 2;
        assertEquals(billpack.twenties(), 2);
    }

    @Test
    public void fifties1() {
        BillPack billpack = new BillPack();
        billpack.bills[4] = 2;
        assertEquals(billpack.fifties(), 2);
    }

    @Test
    public void hundreds1() {
        BillPack billpack = new BillPack();
        billpack.bills[5] = 2;
        assertEquals(billpack.hundreds(), 2);
    }


}