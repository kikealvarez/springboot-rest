package ie.distilledsch.rest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection="users")
public class UserEntity {
    @Id
    private String id;

    @NotEmpty(message = "Email must be set")
    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "Password must be set")
    private String password;

    @NotEmpty(message = "Username must be set")
    private String username;

    @NotEmpty(message = "First name must be set")
    private String firstName;

    @NotEmpty(message = "Last name must be set")
    private String lastName;
}
