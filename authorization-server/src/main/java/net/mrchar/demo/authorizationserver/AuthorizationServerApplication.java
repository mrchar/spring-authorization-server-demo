package net.mrchar.demo.authorizationserver;

import net.mrchar.demo.authorizationserver.model.LocalUser;
import net.mrchar.demo.authorizationserver.repository.LocalUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaAuditing
public class AuthorizationServerApplication {
  private final PasswordEncoder passwordEncoder =
      PasswordEncoderFactories.createDelegatingPasswordEncoder();
  private final LocalUserRepository localUserRepository;

  public AuthorizationServerApplication(LocalUserRepository localUserRepository) {
    this.localUserRepository = localUserRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(AuthorizationServerApplication.class, args);
  }

  @PostConstruct
  public void initData() {
    this.localUserRepository.save(new LocalUser("admin", passwordEncoder.encode("password")));
  }
}
