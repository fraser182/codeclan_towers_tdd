import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    Bedroom bedroom;
    Guest guest;

    @Before
    public void setUp(){
        bedroom = new Bedroom(5, 2, 50, "double");
        guest = new Guest();
    }

    @Test
    public void hasRoomNum() {
        assertEquals(5, bedroom.getRoomNum());
    }
    @Test
    public void hasCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }
    @Test
    public void hasRate() {
        assertEquals(50, bedroom.getRate());
    }
    @Test
    public void hasSize() {
        assertEquals("double", bedroom.getSize());
    }

    @Test
    public void guestsStartsEmpty() {
        assertEquals(0, bedroom.guestsCount());
    }
    @Test
    public void canAddGuest(){
        assertEquals(0, bedroom.guestsCount());
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestsCount());
    }
    @Test
    public void canRemoveGuest(){
        assertEquals(0, bedroom.guestsCount());
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestsCount());
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.guestsCount());
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.guestsCount());
    }
    @Test
    public void canRemoveAllGuests(){
        assertEquals(0, bedroom.guestsCount());
        bedroom.addGuest(guest);
        bedroom.addGuest(new Guest());
        assertEquals(2, bedroom.guestsCount());
        bedroom.removeAllGuests();
        assertEquals(0, bedroom.guestsCount());
    }
}
