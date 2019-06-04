import org.junit.Test;

import static org.junit.Assert.*;

public class PennsylvaniaTaxTest {
    PennsylvaniaTax obj = new PennsylvaniaTax();

    @Test
    public void calculateTax() {

        assertEquals(0, obj.calculateTax(0));
        assertEquals(6, obj.calculateTax(100));


    }

    @Test
    public void applyTaxToPurchase() {
        assertEquals(106, obj.applyTaxToPurchase(100));

    }
}