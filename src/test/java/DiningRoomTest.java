import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom diningRoom;
    Guest guest;


    @Before
    public void setUp(){
        diningRoom = new DiningRoom(5, 30);
        guest = new Guest();
    }

    @Test
    public void hasRoomNum() {
        assertEquals(5, diningRoom.getRoomNum());
    }
    @Test
    public void hasCapacity() {
        assertEquals(30, diningRoom.getCapacity());
    }
    @Test
    public void guestsStartsEmpty() {
        assertEquals(0, diningRoom.guestsCount());
    }
    @Test
    public void canAddGuest(){
        assertEquals(0, diningRoom.guestsCount());
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.guestsCount());
    }
    @Test
    public void canRemoveGuest(){
        assertEquals(0, diningRoom.guestsCount());
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.guestsCount());
        diningRoom.removeGuest(guest);
        assertEquals(0, diningRoom.guestsCount());
        diningRoom.removeGuest(guest);
        assertEquals(0, diningRoom.guestsCount());
    }
    @Test
    public void canRemoveAllGuests(){
        assertEquals(0, diningRoom.guestsCount());
        diningRoom.addGuest(guest);
        diningRoom.addGuest(new Guest());
        assertEquals(2, diningRoom.guestsCount());
        diningRoom.removeAllGuests();
        assertEquals(0, diningRoom.guestsCount());
    }
}
