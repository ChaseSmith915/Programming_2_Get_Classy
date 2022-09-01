import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;

class PersonTest {

    private Person p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "Chase", "Smith", "Mr.", 2000);
        p2 = new Person("000002", "John", "Doe", "Mr.", 1997);
        p3 = new Person("000003", "Sally", "Jackson", "Mrs.", 1999);
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Chaze");
        assertEquals("Chaze", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Smithy");
        assertEquals("Smithy", p1.getLastName());
    }

    @Test
    void setTitle() {
        p2.setTitle("Mrs.");
        assertEquals("Mrs.", p2.getTitle());
    }

    @Test
    void fullName(){
        assertEquals("John Doe", p2.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mrs. Sally", p3.formalName());
    }

    @Test
    void getAge() {
        assertEquals(Calendar.YEAR - p1.getYOB(), p1.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals(22, p1.getAge(2022));
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001, Chase, Smith, Mr., 2000", p1.toCSVDataRecord());
    }
}