package model;

import java.util.List;

public class Hotel {
    private List<Room> roomList;
    private List<Booker> bookers;

    public Hotel(List<Room> roomList, List<Booker> bookers) {
        this.roomList = roomList;
        this.bookers = bookers;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Booker> getBookers() {
        return bookers;
    }

    public void setBookers(List<Booker> bookers) {
        this.bookers = bookers;
    }
}
