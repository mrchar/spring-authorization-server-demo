package net.mrchar.demo.authorizationserver;

import net.mrchar.demo.authorizationserver.model.User;
import net.mrchar.demo.authorizationserver.repository.LocalUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;

import javax.annotation.PostConstruct;
import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class AuthorizationServerApplication {
  private final PasswordEncoder passwordEncoder =
      PasswordEncoderFactories.createDelegatingPasswordEncoder();
  private final LocalUserRepository localUserRepository;
  private final RegisteredClientRepository registeredClientRepository;

  public AuthorizationServerApplication(
      LocalUserRepository localUserRepository,
      RegisteredClientRepository registeredClientRepository) {
    this.localUserRepository = localUserRepository;
    this.registeredClientRepository = registeredClientRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(AuthorizationServerApplication.class, args);
  }

  @PostConstruct
  public void initData() {
    this.localUserRepository.save(new User("admin", passwordEncoder.encode("password")));
    this.registeredClientRepository.save(
        RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("messaging-client")
            .clientSecret("{noop}secret")
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
            .redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
            .redirectUri("http://127.0.0.1:8080/authorized")
            .scope(OidcScopes.OPENID)
            .scope("message.read")
            .scope("message.write")
            .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
            .build());
  }
}
