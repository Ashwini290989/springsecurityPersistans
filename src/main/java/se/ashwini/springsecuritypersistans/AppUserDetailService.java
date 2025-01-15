package se.ashwini.springsecuritypersistans;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.ashwini.springsecuritypersistans.model.AppUser;
import se.ashwini.springsecuritypersistans.repository.AppUserRepository;
import se.ashwini.springsecuritypersistans.repository.AppUserRepository;

import java.util.Collections;


@Service
    public class AppUserDetailService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public AppUserDetailService(AppUserRepository appUserRepository) {
            this.appUserRepository = appUserRepository;

        }
       @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            AppUser appUser = appUserRepository.findByUsername(username);
                   if(appUser == null) {
                        throw new UsernameNotFoundException("User not found");
                    }
           return new org.springframework.security.core.userdetails.User(
                    appUser.getUsername(),
                   appUser.getPassword(),
                    true,true,true,true,
                   Collections.emptyList());
       }

    }

