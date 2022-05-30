package com.example.conference.reservations;


import com.example.conference.AppUser.AppUser;
import com.example.conference.Lecture.Lecture;
import com.example.conference.Lecture.LectureService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    private final LectureService lectureService;
    private final ReservationRepository reservationRepository;

    public ReservationService(LectureService lectureService, ReservationRepository reservationRepository) {
        this.lectureService = lectureService;
        this.reservationRepository = reservationRepository;

    }

    public String makeReservation(int lectureId, AppUser user) throws FileNotFoundException {
        if (!spaceAvailable(lectureId)) throw new IllegalStateException("no space available");
        if (!timeAvailable(user.getLogin(),lectureId)) throw new IllegalStateException("you have already made reservation for this time");

        Reservation reservation = new Reservation(user.getId(), user.getLogin(), lectureId,lectureService.getLecture(lectureId).getName());
        reservationRepository.save(reservation);
        lectureService.addReservation(lectureId);
        sendEmail(user.getEmail(), lectureId);
        return "reservation has been made";
    }

    private void sendEmail(String email,int lectureId) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("powiadomienia.txt");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        printWriter.println(formatter.format(date));
        printWriter.println("to: " + email);
        printWriter.println("You have successfully made reservation for lecture: " + lectureService.getLecture(lectureId).getName());
        printWriter.println("");
        printWriter.close();
    }

    private boolean timeAvailable(String login,int lectureId) {
        List<Lecture> userLectures = getReservedLectures(login);
        Lecture lecture = lectureService.getLecture(lectureId);
        for (Lecture l: userLectures
             ) {
                if(l.getStartingTime().equals(lecture.getStartingTime())) return false;
        }
        return true;
    }

    private boolean spaceAvailable(int lectureId) {
        return lectureService.getReservations(lectureId) < 5;
    }

    public List<Reservation> getReservations(String login){
        return reservationRepository.findByUserLogin(login);
    }


    public List<Lecture> getReservedLectures(String login) {
        List<Lecture> reservedLectures = new ArrayList<>();
        List<Reservation> reservations = getReservations(login);
        for (Reservation r:reservations
             ) {
            reservedLectures.add(lectureService.getLecture(r.getLectureId()));
        }
        return reservedLectures;
    }
}
