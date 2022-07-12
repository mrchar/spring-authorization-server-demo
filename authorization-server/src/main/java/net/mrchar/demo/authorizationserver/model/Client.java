package net.mrchar.demo.authorizationserver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Entity
@Table(name = "`client`")
public class Client extends AbstractPersistable<String> {
  @Setter
  @Column(name = "client_id")
  private String clientId;

  @Setter
  @Column(name = "client_id_issue_at")
  private Instant clientIdIssuedAt;

  @Setter
  @Column(name = "client_secret")
  private String clientSecret;

  @Setter
  @Column(name = "client_secret_expires_at")
  private Instant clientSecretExpiresAt;

  @Setter
  @Column(name = "client_name")
  private String clientName;

  @Setter
  @Column(name = "client_authentication_methods", length = 1000)
  private String clientAuthenticationMethods;

  @Setter
  @Column(name = "authorization_grant_types", length = 1000)
  private String authorizationGrantTypes;

  @Setter
  @Column(name = "redirect_uris", length = 1000)
  private String redirectUris;

  @Setter
  @Column(name = "scopes", length = 1000)
  private String scopes;

  @Setter
  @Column(name = "client_settings", length = 2000)
  private String clientSettings;

  @Setter
  @Column(name = "token_settings", length = 2000)
  private String tokenSettings;

  @Override
  public void setId(String id) {
    super.setId(id);
  }
}
