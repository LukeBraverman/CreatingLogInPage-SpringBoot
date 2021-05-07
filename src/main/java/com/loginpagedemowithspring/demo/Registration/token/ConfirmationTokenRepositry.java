package com.loginpagedemowithspring.demo.Registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepositry extends JpaRepository<ConfirmationToken,Long> {

        Optional<ConfirmationToken> findByToken(String token);

        int updateConfirmedAt(String token,
                              LocalDateTime confirmedAt);
}
