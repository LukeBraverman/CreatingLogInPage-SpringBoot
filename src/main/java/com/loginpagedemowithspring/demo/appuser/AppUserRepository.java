package com.loginpagedemowithspring.demo.appuser;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Transactional(readOnly= true)
@Repository
public interface AppUserRepository {
    Optional<AppUser> findByEmail(String email);


}
