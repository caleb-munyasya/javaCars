package calebDoesJava.checkpoint8.service;

import calebDoesJava.checkpoint8.repository.WebUserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class WebUserDetailsService implements UserDetailsService {
    private final WebUserDetailsRepository webUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Optional.ofNullable(webUserDetailsRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("This User is not known to us"));
    }
}
