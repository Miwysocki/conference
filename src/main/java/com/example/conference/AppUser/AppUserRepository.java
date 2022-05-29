package com.example.conference.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByLogin(String login);

    @Override
    List<AppUser> findAll();

            @Transactional
    @Modifying
        @Query(value = "SELECT * From app_user", nativeQuery = true)
        String test();

        @Transactional
    @Modifying
        @Query(value = "update AppUser u set u.email = :email WHERE u.login = :login ")
        int updateEmail(@Param("login") String login, @Param("email") String email);


}
