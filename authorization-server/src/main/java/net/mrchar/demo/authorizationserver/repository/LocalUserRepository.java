package net.mrchar.demo.authorizationserver.repository;

import net.mrchar.demo.authorizationserver.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {
  @Query("select user from LocalUser user where user.name = :name")
  LocalUser findOneByName(String name);
}
