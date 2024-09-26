package drivenPort.drivenJpa.authentication;

import entity.userDetails.UserDetails;

import java.util.Optional;

public interface AuthenticationRepository {

    Optional<UserDetails> findByUsername2(String username);

}
