package com.loginpagedemowithspring.demo.Registration;

import com.loginpagedemowithspring.demo.Registration.token.ConfirmationToken;
import com.loginpagedemowithspring.demo.Registration.token.ConfirmationTokenService;
import com.loginpagedemowithspring.demo.appuser.AppUser;
import com.loginpagedemowithspring.demo.appuser.AppUserRole;
import com.loginpagedemowithspring.demo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

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
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow() -> new IllegalStateException("token not found");

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }
    }
    confirmationTokenService.
    appUserService.enableAppUser(confirmedToken.getAppUser().getEmail));
    return "confirmed";
}
