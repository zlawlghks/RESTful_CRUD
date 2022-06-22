package zlawlghks.restfullcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zlawlghks.restfullcrud.User.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
