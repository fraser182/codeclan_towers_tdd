import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom bedroom;
    Bedroom bedroom2;
    Bedroom bedroom3;
    Bedroom bedroom4;
    Bedroom bedroom5;
    Bedroom bedroom6;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;
    Guest guest;

    @Before
    public void setUp() {
        hotel = new Hotel("Casa Del Codeclan");
        bedroom = new Bedroom(5, 2, 50, "double");
        bedroom2 = new Bedroom(7, 4, 50, "double x 2");
        bedroom3 = new Bedroom(9, 4, 50, "double x 2");
        bedroom4 = new Bedroom(11, 1, 50, "single");
        bedroom5 = new Bedroom(13, 2, 50, "king");
        bedroom6 = new Bedroom(15, 2, 50, "king");

        diningRoom = new DiningRoom(5, 30);
        conferenceRoom = new ConferenceRoom(5, 15, 50);
        guest = new Guest();
    }

    @Test
    public void hasName() {
        assertEquals("Casa Del Codeclan", hotel.getName());
    }

    @Test
    public void bedroomsStartsEmpty() {
        assertEquals(0, hotel.bedroomsCount());
    }
    @Test
    public void conferenceRoomsStartsEmpty() {
        assertEquals(0, hotel.conferenceRoomsCount());
    }
    @Test
    public void diningRoomsStartsEmpty() {
        assertEquals(0, hotel.diningRoomsCount());
    }
    @Test
    public void canAddBedroom(){
        assertEquals(0, hotel.bedroomsCount());
        hotel.addBedroom(bedroom);
        assertEquals(1, hotel.bedroomsCount());
    }
    @Test
    public void canAddConferenceRoom(){
        assertEquals(0, hotel.conferenceRoomsCount());
        hotel.addConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.conferenceRoomsCount());
    }
    @Test
    public void canAddDiningRoom(){
        assertEquals(0, hotel.diningRoomsCount());
        hotel.addDiningRoom(diningRoom);
        assertEquals(1, hotel.diningRoomsCount());
    }
    @Test
    public void canCheckGuestIntoBedroom(){
        assertEquals(0, bedroom.guestsCount());
        hotel.checkin(bedroom, guest);
        assertEquals(1, bedroom.guestsCount());
    }
    @Test
    public void canCheckGuestIntoConferenceRoom(){
        assertEquals(0, conferenceRoom.guestsCount());
        hotel.checkin(conferenceRoom, guest);
        assertEquals(1, conferenceRoom.guestsCount());
    }
    @Test
    public void cannotCheckGuestsIntoFullBedroom(){
        assertEquals(0, bedroom.guestsCount());
        hotel.checkin(bedroom, guest);
        assertEquals(1, bedroom.guestsCount());
        hotel.checkin(bedroom, new Guest());
        assertEquals(2, bedroom.guestsCount());
        hotel.checkin(bedroom, new Guest());
        assertEquals(2, bedroom.guestsCount());
    }
    @Test
    public void canCheckSpecificGuestOutOfBedroom(){
        assertEquals(0, bedroom.guestsCount());
        hotel.checkin(bedroom, guest);
        assertEquals(1, bedroom.guestsCount());
        hotel.checkout(bedroom, guest);
        assertEquals(0, bedroom.guestsCount());
    }
    @Test
    public void canCheckSpecificGuestOutOfConferenceRoom(){
        assertEquals(0, conferenceRoom.guestsCount());
        hotel.checkin(conferenceRoom, guest);
        assertEquals(1, conferenceRoom.guestsCount());
        hotel.checkout(conferenceRoom, guest);
        assertEquals(0, conferenceRoom.guestsCount());
    }
    @Test
    public void canClearBedroom(){
        assertEquals(0, bedroom.guestsCount());
        hotel.checkin(bedroom, guest);
        assertEquals(1, bedroom.guestsCount());
        hotel.checkin(bedroom, new Guest());
        assertEquals(2, bedroom.guestsCount());
        hotel.clear(bedroom);
        assertEquals(0, bedroom.guestsCount());
    }
    @Test
    public void canClearConferenceRoom(){
        assertEquals(0, conferenceRoom.guestsCount());
        hotel.checkin(conferenceRoom, guest);
        assertEquals(1, conferenceRoom.guestsCount());
        hotel.checkin(conferenceRoom, new Guest());
        assertEquals(2, conferenceRoom.guestsCount());
        hotel.clear(conferenceRoom);
        assertEquals(0, conferenceRoom.guestsCount());
    }
    @Test
    public void canBookBedroom(){
        assertEquals(0, hotel.bookingsCount());
        hotel.bookRoom(bedroom, 2);
        assertEquals(1, hotel.bookingsCount());
    }
    @Test
    public void canGetBill(){
        assertEquals(0, hotel.bookingsCount());
        Booking booking = hotel.bookRoom(bedroom, 2);
        assertEquals(1, hotel.bookingsCount());
        assertEquals(100, booking.bill());
    }
    @Test
    public void canGetVacantBedrooms(){
        assertEquals(0, hotel.bedroomsCount());
        hotel.addBedroom(bedroom);
        assertEquals(1, hotel.bedroomsCount());

//        for (int i = 0; i < 5; i++){
//            hotel.addBedroom(new Bedroom(15, 2, 50, "single"));
//        }
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.addBedroom(bedroom4);
        hotel.addBedroom(bedroom5);
        hotel.addBedroom(bedroom6);
        assertEquals(6, hotel.bedroomsCount());
        assertEquals(0, bedroom.guestsCount());
        hotel.checkin(bedroom5, guest);
        assertEquals(1, bedroom5.guestsCount());

        ArrayList<Bedroom> vacantBedrooms = hotel.vacantBedrooms();
        assertEquals(5, vacantBedrooms.size());
    }

}
