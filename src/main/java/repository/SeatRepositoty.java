package repository;

import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SeatRepositoty {
    private final Map<String , Set<Integer>> userBookings = new ConcurrentHashMap<>();
    private final Set<Integer> bookedSeats = ConcurrentHashMap.newKeySet();
    private final int totalSets = 20;
    public Set<Integer> getUserBookedSeats(String username){
        return userBookings.getOrDefault(username, new HashSet<>());
    }

    public Set<Integer> getAllBookedSeats(){
    return bookedSeats;
}
public void bookSeats (String username, Set<Integer> seats)
{
    userBookings.compute(username,(key,oldset)->{
    Set<Integer> newSet = oldset != null? new HashSet<>(oldset):new HashSet<>();
    newSet.addAll(seats);
    return newSet;
    });
    bookedSeats.addAll(seats);
}
public int getTotalSets(){
   return totalSets;
}
public List<Integer> getAllSeats(){
        List<Integer> seats = new ArrayList<>();
        for (int i=1 ;i<=totalSets;i++)
        {
            seats.add(i);
        }
        return seats;
}
}

