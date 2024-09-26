package entity.token;

import entity.abstracts.Base;
import entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Token extends Base {
    private String token;
    private boolean loggedOut;
    private User user;
}
