package com.example.conference.registration;

import com.example.conference.AppUser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping(path = "/register")
    public String register(@RequestBody RegistrationRequest request) {
        try {
            return  registrationService.register(request);
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping(path = "/all")
    public List<AppUser> getAllUsers(){
        return registrationService.listUsersEmails();
    }

}
