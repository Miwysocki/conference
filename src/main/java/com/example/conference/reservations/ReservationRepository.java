package com.example.conference.reservations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
List<Reservation> findByUserId(Long userId);
    List<Reservation> findByUserLogin(String login);
}
