import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CashRegisterTest {



    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void drawerValue() {
        Drawer drawer = new Drawer(1, 1, 1, 1, 1, 1,1,1,1,1);
        CashRegister cashRegister = new CashRegister(drawer);
        assertEquals(cashRegister.drawerValue(), 186,41);

    }

    @Test
    public void testConstructors(){
        CashRegister cashRegister1 = new CashRegister(10,10,10,10,10,10,10,10,10,10);
        CashRegister cashRegister2 = new CashRegister(2,2,2,2,2,2,2,2,2,2, new PennsylvaniaTax());

    }

    @Test
    public void coinsInDrawer() {
        CoinPack coinPack = new CoinPack();
        //Drawer drawer = new Drawer(coinPack, new BillPack());
        CashRegister cashRegister = new CashRegister( new BillPack(), coinPack);
        assertEquals(cashRegister.coinsInDrawer(),coinPack);


    }

    @Test
    public void billsInDrawer() {
        CoinPack coinPack = new CoinPack();
        BillPack billPack = new BillPack();
        //Drawer drawer = new Drawer(coinPack, new BillPack());
        CashRegister cashRegister = new CashRegister( billPack, coinPack);
        assertEquals(cashRegister.billsInDrawer(),billPack);
    }

    @Test
    public void purchaseItemInsufficientFundInDrawer() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Insufficient funds in drawer to process change");

        CashRegister cashRegister = new CashRegister();
        //Throw IllegalStateException
        double value = cashRegister.purchaseItem(25, 1,1,1,1,1,1,1,1,1,1);
    }

    @Test
    public void purchaseItemInsufficientTendered() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Insufficient tendered to cover cost");

        CashRegister cashRegister = new CashRegister();
        //Throw IllegalStateException
        double value = cashRegister.purchaseItem(250, 1,1,1,1,1,1,1,1,1,1);

    }

    @Test
    public void purchaseItem() {
        CashRegister cashRegister = new CashRegister();
        //Case for change due = 0
        double value2 = cashRegister.purchaseItem(20,1,0,0,1,0,0,0,0,2,0);
        assertEquals(value2, 0,0);

        double value = cashRegister.purchaseItem(20, 1,1,1,1,1,1,1,1,1,1 );
        assertEquals(value, 165,21);



    }


    @Test
    public void purchaseItem1() {
        CashRegister cashRegister = new CashRegister(8,8,8,8,8,8,8,8,8,8);
        assertEquals(cashRegister.purchaseItem(80,0,5,1,1,1,1,0,0,0,0), 120, 2);
    }

    @Test
    public void scanItem() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.scanItem(100, "Bottle");
        cashRegister.scanItem(10, "chocolate");
        assertEquals(cashRegister.scanItem(1, "nothing"), 111, 00);
    }

    @Test
    public void finalizePurchase() {
        BillPack billPack = new BillPack(1,1,1,1,1,1);
        CoinPack coinPack = new CoinPack(1,1,1,1);
        CashRegister cashRegister = new CashRegister(billPack, coinPack);
        cashRegister.scanItem(20, "Bottle");
        assertEquals(cashRegister.finalizePurchase(billPack,coinPack),165,21 );

    }

    @Test
    public void finalizePurchaseExceptionCase() {
        thrown.expect(IllegalStateException.class);
        BillPack billPack = new BillPack(1,1,1,1,1,1);
        CoinPack coinPack = new CoinPack(1,1,1,1);
        CashRegister cashRegister = new CashRegister(billPack, coinPack);
        cashRegister.scanItem(25, "Bottle");
        //cashRegister.scanItem(10, "chocolate");
        assertEquals(cashRegister.finalizePurchase(billPack,coinPack),165,21 );

    }
}