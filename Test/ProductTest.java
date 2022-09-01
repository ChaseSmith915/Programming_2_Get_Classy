import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Silly String", "Spray your friends", 5.00);
        p2 = new Product("000002", "UFO", "travels faster than light", 999999.00);
        p3 = new Product("000003", "Dr Lighting", "Store brand dr pepper", 1.00);

    }

    @Test
    void setProductName() {
        p1.setProductName("FunnyString");
        assertEquals("FunnyString", p1.getProductName());
    }

    @Test
    void setProductDesc() {
        p2.setProductDesc("Alien Artifact");
        assertEquals("Alien Artifact", p2.getProductDesc());
    }

    @Test
    void setProductCost() {
        p3.setProductCost(2.00);
        assertEquals(2.00, p3.getProductCost());
    }

    @Test
    void toCSVDataRecord(){
        assertEquals("000001, Silly String, Spray your friends, 5.0", p1.toCSVDataRecord());
    }

}

