package repository;

import com.tms.lesson45.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByLogin(String login);
}
