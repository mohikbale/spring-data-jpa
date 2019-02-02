package springbootdatajpaexample.halaqohit.repository;

import springbootdatajpaexample.halaqohit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
