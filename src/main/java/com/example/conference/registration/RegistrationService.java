package com.example.conference.registration;


import com.example.conference.AppUser.AppUser;
import com.example.conference.AppUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;


    public String register(RegistrationRequest request) {
         appUserService.signUpUser(
                new AppUser(
                        request.getLogin(),
                        request.getEmail(),
                        request.getPassword()
                )
        );
        return "Registered successfully";
    }

    public List<AppUser> listUsersEmails(){
        return appUserService.getAllUsers();
    }




}
