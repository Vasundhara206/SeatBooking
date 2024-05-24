package service;

import model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SeatRepositoty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements  BookingService{

    @Autowired
    private SeatRepositoty seatRepositoty;
    @Override
    public List<Seat> getSeats(String username) {
        Set<Integer> userBookedSeats = seatRepositoty.getUserBookedSeats(username);
        Set<Integer> allBookedSeats = seatRepositoty.getAllBookedSeats();
        int totalSeats = seatRepositoty.getTotalSets();
        return seatRepositoty.getAllSeats().stream().map(seatId -> {
            Seat seat = new Seat();
            seat.setId(seatId);
            if (userBookedSeats.contains(seatId)){
                seat.setStatus("User Booked");
            } else if (allBookedSeats.contains(seatId)) {
                seat.setStatus("Booked");
            }else {
                seat.setStatus("available");
            }
            return seat;
        }).collect(Collectors.toList());
    }

    @Override
    public void bookSeats(String username, List<Integer> seatIds) {

        seatRepositoty.bookSeats(username, new HashSet<>(seatIds));

    }
}
