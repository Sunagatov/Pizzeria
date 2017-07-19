import models.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Zufar on 19-Jul-17.
 */
public class ClientTest {
    private Client client;

    @Before
    public void init() {
        client = new Client(352353, "Honey", "Senny", "Rurry", 543634);
    }

    @After
    public void tearDown() {
        client = null;
    }

    @Test
    public void checkName() throws Exception {
        String expected = "Honey";
        String actual = client.getName();
        assertEquals("Unexpected string value", expected, actual);
    }

    @Test
    public void checkID() throws Exception {
        assertNotNull(client.getID());
    }

    @Test
    public void checkTelephoneNumber() throws Exception {
        int expected = 543634;
        int actual = client.getTelephoneNumber();
        assertEquals("Unexpected int value", expected, actual);
    }

    @Test
    public void checkToString() throws Exception {
        String expected = " Name: Honey Surname: Senny Patronymic: Rurry";
        String actual = client.toString();
        assertEquals("Unexpected string value", expected, actual);
    }

}