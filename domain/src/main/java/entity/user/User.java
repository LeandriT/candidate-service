package entity.user;

import entity.abstracts.Base;
import entity.enums.Role;
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
public class User extends Base {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;
}
