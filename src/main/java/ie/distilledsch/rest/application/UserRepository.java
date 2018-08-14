package ie.distilledsch.rest.application;

import ie.distilledsch.rest.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
    @Override
    void delete(UserEntity deleted);

    User findByUsername(String username);
}
