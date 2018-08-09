package ie.distilledsch.rest.domain.service;

import ie.distilledsch.rest.application.UserRepository;
import ie.distilledsch.rest.domain.entity.User;
import ie.distilledsch.rest.domain.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user) throws UserNotFoundException {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }

        throw new UserNotFoundException(new StringBuilder("No user found with id = ").append(user.getId()).toString());
    }

    public void deleteUser(String id) throws UserNotFoundException {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }

        throw new UserNotFoundException(new StringBuilder("No user found with id = ").append(id).toString());
    }

}
