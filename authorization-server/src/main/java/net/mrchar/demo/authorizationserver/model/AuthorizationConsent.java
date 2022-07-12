package net.mrchar.demo.authorizationserver.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "`authorizationConsent`")
@IdClass(AuthorizationConsent.AuthorizationConsentId.class)
public class AuthorizationConsent {
  @Setter
  @Id
  @Column(name = "registered_client_id")
  private String registeredClientId;

  @Setter
  @Id
  @Column(name = "principal_name")
  private String principalName;

  @Setter
  @Column(name = "authorities", length = 1000)
  private String authorities;

  @Getter
  @EqualsAndHashCode
  public static class AuthorizationConsentId implements Serializable {
    @Setter private String registeredClientId;
    @Setter private String principalName;
  }
}
