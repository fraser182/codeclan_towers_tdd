import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;

    public Hotel(String name) {
        this.name = name;
        this.bedrooms = new ArrayList<Bedroom>();
        this.diningRooms = new ArrayList<DiningRoom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.bookings = new ArrayList<Booking>();
    }

    public String getName() {
        return name;
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }
    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }
    public void addDiningRoom(DiningRoom diningRoom){
        this.diningRooms.add(diningRoom);
    }


    public int bedroomsCount(){
        return this.bedrooms.size();
    }
    public int conferenceRoomsCount(){
        return this.conferenceRooms.size();
    }
    public int diningRoomsCount(){
        return this.diningRooms.size();
    }

    public void checkin(Bedroom bedroom, Guest guest) {
        bedroom.addGuest(guest);
    }
    public void checkin(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.addGuest(guest);
    }

    public void checkout(Bedroom bedroom, Guest guest) {
        bedroom.removeGuest(guest);
    }
    public void checkout(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.removeGuest(guest);
    }

    public void clear(Bedroom bedroom) {
        bedroom.removeAllGuests();
    }
    public void clear(ConferenceRoom conferenceRoom) {
        conferenceRoom.removeAllGuests();
    }

    public int bookingsCount() {
        return this.bookings.size();
    }

    public Booking bookRoom(Bedroom bedroom, int duration) {
        Booking booking = new Booking(bedroom, duration);
        this.bookings.add(booking);
        return booking;
    }

    public ArrayList<Bedroom> vacantBedrooms() {
        ArrayList<Bedroom> vacantBedrooms = new ArrayList<Bedroom>();
        for (int i = 0; i < this.bedroomsCount(); i++){
            if (this.bedrooms.get(i).guestsCount() == 0){
                vacantBedrooms.add(this.bedrooms.get(i));
            }
        }
        return vacantBedrooms;
    }
}
