import java.util.ArrayList;

public class ConferenceRoom {
    private int roomNum;
    private int capacity;
    private int rate;
    private ArrayList<Guest> guests;

    public ConferenceRoom(int roomNum, int capacity, int rate) {
        this.roomNum = roomNum;
        this.capacity = capacity;
        this.rate = rate;
        this.guests = new ArrayList<Guest>();
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRate() {
        return rate;
    }

    public int guestsCount() {
        return this.guests.size();
    }

    public void addGuest(Guest guest) {
        if (this.guestsCount() < this.capacity && guest != null) {
            this.guests.add(guest);
        }
    }
    public Guest removeGuest(Guest guest) {
        if (this.guests.remove(guest)){
            return guest;
        }
        return null;
    }
    public void removeAllGuests() {
        this.guests.clear();
    }
}
