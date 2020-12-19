package test.com.oms.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.oms.bean.Order;
import com.oms.bean.OrderLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TotalCostBlackBoxTest {
    Order  order = new Order();
    Double expected = 0.0;

    public TotalCostBlackBoxTest(String address, ArrayList<OrderLine> orderLines, Double expected) throws Exception {
        super();
        System.out.println(address);
        System.out.println(orderLines);
        System.out.println(expected);
        order.setCustomerAddress(address);
        order.setOrderLines(orderLines);
        this.expected = expected;
        order.setOrderLines(orderLines);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "Hà Nội",setWeight(2), 122000.0},
                {  "HN",setWeight(2), 122000.0},
                {  "HCM",setWeight(4), 127000.0},
                {  "Hồ Chí Minh",setWeight(4), 127000.0},
                {  "Hà Nam",setWeight(4.5f), 150000.0},
                { "Hà tây",setWeight(0.5f), 130000.0 }
        });
    }


    @Test
    public void getTotalCost() {
        assertEquals("Tong: ",expected, order.getTotalCost(), 0.00001);
    }

    private static ArrayList<OrderLine>  setWeight(float weight){
        ArrayList orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine("1", "Book", 1, 100000, weight);
        orderLines.add(orderLine);
        return  orderLines;
    }
}
