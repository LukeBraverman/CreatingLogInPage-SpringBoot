package com.loginpagedemowithspring.demo.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepositry confirmationTokenRepositry;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepositry.save(token);
    }
}
