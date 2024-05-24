package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/seats")
    public void bookSeats(@RequestBody BookingRequest request) {
        bookingService.bookSeats(request.getUsername(),request.getSeats());
    }
    public static class BookingRequest{
        private String username;
        private List<Integer> seats;

        public BookingRequest(){

        }
        public BookingRequest(String username, List<Integer> seats) {
            this.username = username;
            this.seats = seats;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<Integer> getSeats() {
            return seats;
        }

        public void setSeats(List<Integer> seats) {
            this.seats = seats;
        }
    }
}
