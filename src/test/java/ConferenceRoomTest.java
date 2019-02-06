import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void setUp(){
        conferenceRoom = new ConferenceRoom(5, 15, 50);
        guest = new Guest();
    }

    @Test
    public void hasRoomNum() {
        assertEquals(5, conferenceRoom.getRoomNum());
    }
    @Test
    public void hasCapacity() {
        assertEquals(15, conferenceRoom.getCapacity());
    }
    @Test
    public void hasRate() {
        assertEquals(50, conferenceRoom.getRate());
    }
    @Test
    public void guestsStartsEmpty() {
        assertEquals(0, conferenceRoom.guestsCount());
    }
    @Test
    public void canAddGuest(){
        assertEquals(0, conferenceRoom.guestsCount());
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.guestsCount());
    }
    @Test
    public void canRemoveGuest(){
        assertEquals(0, conferenceRoom.guestsCount());
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.guestsCount());
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.guestsCount());
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.guestsCount());
    }
    @Test
    public void canRemoveAllGuests(){
        assertEquals(0, conferenceRoom.guestsCount());
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(new Guest());
        assertEquals(2, conferenceRoom.guestsCount());
        conferenceRoom.removeAllGuests();
        assertEquals(0, conferenceRoom.guestsCount());
    }
}
