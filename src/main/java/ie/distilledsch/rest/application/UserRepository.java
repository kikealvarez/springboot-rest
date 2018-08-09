package ie.distilledsch.rest.application;

import ie.distilledsch.rest.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Override
    void delete(User deleted);
}
