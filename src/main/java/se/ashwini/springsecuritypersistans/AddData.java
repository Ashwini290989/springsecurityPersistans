package se.ashwini.springsecuritypersistans;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.ashwini.springsecuritypersistans.model.AppUser;
import se.ashwini.springsecuritypersistans.repository.AppUserRepository;


@Component

public class AddData {
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;

    public AddData(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
    }

    @PostConstruct
        public void init() {
            if(appUserRepository.findByUsername("user")==null) {
                AppUser appUser = new AppUser();
                appUser.setUsername("user");
                appUser.setPassword(passwordEncoder.encode("password"));
                appUserRepository.save(appUser);


            };
        }
    }


