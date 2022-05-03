package model;

import java.util.List;

public class Room {
    private int price;
    private String typeOfRoom;
    private Booker representative;// người đại diện thanh toán
    private String type;
    private int numberOfBookDays;
    List<Booker> bookers;

    public Room(String typeOfRoom, Booker representative, String type, List<Booker> bookers,int numberOfBookDays) {
        this.typeOfRoom = typeOfRoom;
        if(typeOfRoom.equals("A")) price = 500;
        if(typeOfRoom.equals("B")) price = 300;
        if(typeOfRoom.equals("C")) price = 100;
        this.representative = representative;
        this.type = type;
        this.bookers = bookers;
        this.numberOfBookDays = numberOfBookDays;
    }
    public Room(String typeOfRoom, Booker representative, String type) {
        this.typeOfRoom = typeOfRoom;
        if(typeOfRoom.equals("A")) price = 500;
        if(typeOfRoom.equals("B")) price = 300;
        if(typeOfRoom.equals("C")) price = 100;
        this.representative = representative;
        this.type = type;
        this.numberOfBookDays = numberOfBookDays;

    }

    public int getNumberOfBookDays() {
        return numberOfBookDays;
    }

    public void setNumberOfBookDays(int numberOfBookDays) {
        this.numberOfBookDays = numberOfBookDays;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public Booker getRepresentative() {
        return representative;
    }

    public void setRepresentative(Booker representative) {
        this.representative = representative;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Booker> getBookers() {
        return bookers;
    }

    public void setBookers(List<Booker> bookers) {
        this.bookers = bookers;
    }
}
