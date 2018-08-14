package ie.distilledsch.rest.domain.service;

import ie.distilledsch.rest.application.UserRepository;
import ie.distilledsch.rest.domain.entity.UserEntity;
import ie.distilledsch.rest.domain.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserEntity> listUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUser(String id) {
        return userRepository.findById(id);
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity editUser(UserEntity userEntity) throws UserNotFoundException {
        if (userRepository.existsById(userEntity.getId())) {
            return userRepository.save(userEntity);
        }

        throw new UserNotFoundException(new StringBuilder("No userEntity found with id = ").append(userEntity.getId()).toString());
    }

    public void deleteUser(String id) throws UserNotFoundException {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }

        throw new UserNotFoundException(new StringBuilder("No user found with id = ").append(id).toString());
    }

}
