import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DrawerTest {

    @Test
    public void drawerTotalInCents() {
        Drawer drawer = new Drawer(1,1,1,1,1,1,1,1,1,1);
        assertEquals(drawer.drawerTotalInCents(),18641 );
    }

    @Test
    public void penny() {
        Drawer drawer = new Drawer(1,1,1,1,1,1,1,1,1,1);
        assertEquals(drawer.penny(),1 );

    }

    @Test
    public void nickle() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.nickle(),5);
    }

    @Test
    public void dime() {
        Drawer drawer = new Drawer(1,5,10,1,1,1,1,1,1,1);
        assertEquals(drawer.dime(),10);

    }

    @Test
    public void quarter() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.quarter(),1);
    }

    @Test
    public void one() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.one(),1);
    }

    @Test
    public void five() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.five(),1);
    }

    @Test
    public void ten() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.ten(),1);
    }

    @Test
    public void twenty() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.twenty(),1);
    }

    @Test
    public void fifty() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.fifty(),1);
    }

    @Test
    public void hundred() {
        Drawer drawer = new Drawer(1,5,1,1,1,1,1,1,1,1);
        assertEquals(drawer.hundred(),1);
    }

    @Test
    public void coinPack() {
        CoinPack coinPack = new CoinPack();
        BillPack billPack = new BillPack();
        Drawer drawer = new Drawer(coinPack, billPack);
        assertEquals(drawer.coinPack(), coinPack);
    }

    @Test
    public void billPack() {
        CoinPack coinPack = new CoinPack();
        BillPack billPack = new BillPack();
        Drawer drawer = new Drawer(coinPack, billPack);
        assertEquals(drawer.billPack(), billPack);
    }

    @Test
    public void depositChange() {
        Drawer drawer = new Drawer();
        drawer.depositChange(1,1,1,1);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void depositChangeErrorThrownTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Can't deposit negative coin value");
        Drawer drawer = new Drawer();
        drawer.depositChange(-11,1,1,1);    }


    @Test
    public void depositChange1() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        BillPack billPack = new BillPack(4,4,4,4,4,4);
        Drawer drawer = new Drawer();
        Drawer drawer1 = new Drawer(coinPack, billPack);
        drawer.depositChange(coinPack);
        drawer.depositChange(1,1,1,1);

    }
    @Test
    public void depositBillsErrorThrownTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Can't deposit negative bill value");
        Drawer drawer = new Drawer();
        drawer.depositBills(-11,1,1,1, 1,1);    }




    @Test
    public void depositBills() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        BillPack billPack = new BillPack(4,4,4,4,4,4);
        Drawer drawer = new Drawer();
        drawer.depositBills(billPack);

        Drawer drawer1 = new Drawer(coinPack, billPack);
        drawer1.depositBills(1,1,1,1,1,1);
        long ones = billPack.bills[0];

        assertEquals(ones,5 );
    }

    @Test
    public void removeChange() {
        CoinPack coinPack = new CoinPack(4,4,4,4);
        BillPack billPack = new BillPack(4,4,4,4,4,4);
        Drawer drawer = new Drawer();
        drawer.removeChange(1,1,1,1);
        Drawer drawer1 = new Drawer(coinPack, billPack);
        drawer.removeChange(coinPack);
        assertTrue(drawer1.removeChange(coinPack));
        assertFalse(drawer.removeChange(3,2,1,1));

    }

    @Test
    public void removeBills(){
        CoinPack coinPack = new CoinPack(4,4,4,4);
        BillPack billPack = new BillPack(4,4,4,4,4,4);
        Drawer drawer = new Drawer(coinPack,billPack);
        boolean flag = drawer.removeBills(8,8,8,8,8,8);
        assertFalse(flag);

        boolean flag1 = drawer.removeBills(4,4,4,4,4,4);
        assertTrue(flag1);
    }
}