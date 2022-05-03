package Service;

import model.Booker;
import model.Hotel;
import model.Room;

import java.util.Optional;

public class HotelService {
    Hotel hotel;

    public HotelService(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean addBooker(Booker booker) {
        Optional<Booker> record = hotel.getBookers().stream().filter(b -> b.equals(booker)).findFirst();
        if (record.isPresent()) return false;
        return hotel.getBookers().add(booker);
    }

    public boolean deleteBooker(String cccd) {
        Optional<Booker> record = hotel.getBookers().stream().filter(b -> b.getCccd().equals(cccd)).findFirst();
        if (record.isPresent())
            return hotel.getBookers().remove(record.get());
        return false;
    }
    public int calculateCost(Room room){
        return room.getNumberOfBookDays()*room.getPrice();
    }
}
