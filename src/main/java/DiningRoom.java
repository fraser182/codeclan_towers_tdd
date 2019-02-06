import java.util.ArrayList;

public class DiningRoom {
    private int roomNum;
    private int capacity;
    private ArrayList<Guest> guests;

    public DiningRoom(int roomNum, int capacity) {
        this.roomNum = roomNum;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getCapacity() {
        return capacity;
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
