package com.example.conference.registration;


import com.example.conference.AppUser.AppUser;
import com.example.conference.AppUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@AllArgsConstructor
@CrossOrigin(origins ="*")
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
         appUserService.signUpUser(
                new AppUser(
                        request.getLogin(),
                        request.getEmail(),
                        request.getPassword()
                )
        );
        return "Registed succesfully";
    }

    public List<AppUser> listUsersEmails(){
//        List<AppUser> list =  appUserService.getAllUsers();
//        for (AppUser user : list
//             ) {
//
//
//        }
//

        return appUserService.getAllUsers();
    }



}
