package net.mrchar.demo.authorizationserver.repository;

import net.mrchar.demo.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalUserRepository extends JpaRepository<User, Long> {
  @Query("select user from User user where user.name = :name")
  User findOneByName(String name);
}
