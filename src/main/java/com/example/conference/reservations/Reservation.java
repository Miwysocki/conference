package com.example.conference.reservations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    Long id;
    Long userId;
    int lectureId;
    String userLogin;
    String lectureName;



    public Reservation(Long userId,String userLogin, int lectureId,String lectureName) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }
}
