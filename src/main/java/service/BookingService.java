package service;


import model.Seat;

import java.util.List;

public interface BookingService {
    List<Seat> getSeats(String username);
    void bookSeats(String username, List<Integer> seatIds);
}
