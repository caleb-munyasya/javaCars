package calebDoesJava.checkpoint8.repository;

import calebDoesJava.checkpoint8.domain.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserDetailsRepository extends JpaRepository<WebUser, Integer> {
    WebUser findByUsername(String username);
}
