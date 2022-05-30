package com.example.conference.reservations;

import com.example.conference.AppUser.AppUser;
import com.example.conference.Lecture.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reserve")
    public String makeReservation(@RequestParam int lectureId, @AuthenticationPrincipal AppUser user){
        try {
            return reservationService.makeReservation(lectureId, user);
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/cancel")
    public String cancelReservation(@RequestParam Long id){
        return reservationService.cancelReservation(id);
    }

    @GetMapping("/api/reservations/user")
    public List<Lecture> getReservedLectures(@RequestParam String login){
        return reservationService.getReservedLectures(login);
    }
}
