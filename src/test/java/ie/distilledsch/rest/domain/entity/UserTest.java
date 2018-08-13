package ie.distilledsch.rest.domain.entity;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class UserTest {
    @Test
    public void userGettersAndSetters() {
        User user = new User();

        user.setId("abc");
        user.setEmail("test@test.ie");
        user.setPassword("password");
        user.setFirstName("john");
        user.setLastName("doe");

        assertSame("abc", user.getId());
        assertSame("test@test.ie", user.getEmail());
        assertSame("password", user.getPassword());
        assertSame("john", user.getFirstName());
        assertSame("doe", user.getLastName());
    }
}
