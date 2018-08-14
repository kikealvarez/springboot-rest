package ie.distilledsch.rest.domain.service;

import ie.distilledsch.rest.application.UserRepository;
import ie.distilledsch.rest.domain.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserEntityServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listUsers()
    {
    }
}
