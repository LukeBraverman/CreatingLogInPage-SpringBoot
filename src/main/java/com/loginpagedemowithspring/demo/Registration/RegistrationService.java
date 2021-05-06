package com.loginpagedemowithspring.demo.Registration;

import com.loginpagedemowithspring.demo.appuser.AppUser;
import com.loginpagedemowithspring.demo.appuser.AppUserRole;
import com.loginpagedemowithspring.demo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));
    }
}
