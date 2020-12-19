package test.com.oms.media;

import com.oms.bean.Media;
import com.oms.bean.OrderLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MatchMediaWhiteBoxTest {
    Media thisMedia = new Media("12346","Hello Book Computer", "Book", 100);
    Media thatMedia;
    boolean expected;

    public MatchMediaWhiteBoxTest( Media thatMedia, Boolean expected) throws Exception {
        super();
        this.thatMedia = thatMedia;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        Media media1 = new Media();
        media1.setId("12345");
        Media media2 = new Media();
        media2.setId("1234");
        media2.setTitle("Book Store Computer");
        Media media3 = new Media();
        media3.setId("1234");
        media3.setTitle("Book Computer");
        media3.setCategory("DVD");
        Media media4 = new Media();
        media4.setId("1234");
        media4.setTitle("Book Computer");
        media4.setCategory("Book");
        media4.setCost(200);
        Media media5 = new Media();
        media5.setId("1234");
        media5.setTitle("Book Computer");
        media5.setCategory("Book");
        media5.setCost(100);
        return Arrays.asList(new Object[][] {
                { null, true},
                { media1, false },
                { media2, false },
                { media3, false },
                { media4, false },
                { media5, true },
        });
    }

    @Test
    public void matchMedia() {
        assertEquals("math media false",expected, thisMedia.match(thatMedia));
    }

    private static ArrayList<OrderLine>  setWeight(float weight){
        ArrayList orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine("1", "Book", 1, 100000, weight);
        orderLines.add(orderLine);
        return  orderLines;
    }
}
@RunWith(Suite.class)
@Suite.SuiteClasses({MatchMediaWhiteBoxTest.class})
 class TotalCostTestSuite {
}