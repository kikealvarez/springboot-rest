package ie.distilledsch.rest.domain.entity;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class UserEntityTest {
    @Test
    public void userGettersAndSetters() {
        UserEntity userEntity = new UserEntity();

        userEntity.setId("abc");
        userEntity.setEmail("test@test.ie");
        userEntity.setPassword("password");
        userEntity.setFirstName("john");
        userEntity.setLastName("doe");

        assertSame("abc", userEntity.getId());
        assertSame("test@test.ie", userEntity.getEmail());
        assertSame("password", userEntity.getPassword());
        assertSame("john", userEntity.getFirstName());
        assertSame("doe", userEntity.getLastName());
    }
}
