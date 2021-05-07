package com.loginpagedemowithspring.demo.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepositry confirmationTokenRepositry;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepositry.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepositry.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepositry.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
