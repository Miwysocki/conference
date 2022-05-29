package com.example.conference.registration;

import com.example.conference.AppUser.AppUser;
import com.example.conference.AppUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
@AllArgsConstructor
public class RegistrationController {

    private final AppUserService appUserService;
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

    @PutMapping(path = "/update")
    public int updateEmail(@AuthenticationPrincipal AppUser user, @RequestParam String newEmail){
 return appUserService.updateEmail(user.getLogin(),newEmail);
    }
    @GetMapping("/currentusername")
    public String currentUserName(@AuthenticationPrincipal AppUser user) {
        return user.getUsername();
    }
}
