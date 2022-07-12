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
@Table(name = "`authorization`")
public class Authorization extends AbstractPersistable<String> {
  @Setter
  @Column(name = "registered_client_id")
  private String registeredClientId;

  @Setter
  @Column(name = "principal_name")
  private String principalName;

  @Setter
  @Column(name = "authorization_grant_type")
  private String authorizationGrantType;

  @Setter
  @Column(name = "attributes", length = 4000)
  private String attributes;

  @Setter
  @Column(name = "state", length = 500)
  private String state;

  @Setter
  @Column(name = "authorization_code_value", length = 4000)
  private String authorizationCodeValue;

  @Setter
  @Column(name = "authorization_code_issue_at")
  private Instant authorizationCodeIssuedAt;

  @Setter
  @Column(name = "authorization_code_expires_at")
  private Instant authorizationCodeExpiresAt;

  @Setter
  @Column(name = "authorization_code_metadata")
  private String authorizationCodeMetadata;

  @Setter
  @Column(name = "access_token_value", length = 4000)
  private String accessTokenValue;

  @Setter
  @Column(name = "access_token_issue_at")
  private Instant accessTokenIssuedAt;

  @Setter
  @Column(name = "access_token_expires_at")
  private Instant accessTokenExpiresAt;

  @Setter
  @Column(name = "access_token_metadata", length = 2000)
  private String accessTokenMetadata;

  @Setter
  @Column(name = "access_token_type")
  private String accessTokenType;

  @Setter
  @Column(name = "access_token_scopes", length = 1000)
  private String accessTokenScopes;

  @Setter
  @Column(name = "refresh_token_value", length = 4000)
  private String refreshTokenValue;

  @Setter
  @Column(name = "refresh_token_issued_at")
  private Instant refreshTokenIssuedAt;

  @Setter
  @Column(name = "refresh_token_expires_at")
  private Instant refreshTokenExpiresAt;

  @Setter
  @Column(name = "refresh_token_metadata", length = 2000)
  private String refreshTokenMetadata;

  @Setter
  @Column(name = "oidc_id_token_value", length = 4000)
  private String oidcIdTokenValue;

  @Setter
  @Column(name = "oidc_id_token_issued_at")
  private Instant oidcIdTokenIssuedAt;

  @Setter
  @Column(name = "oidc_id_token_expires_at")
  private Instant oidcIdTokenExpiresAt;

  @Setter
  @Column(name = "oidc_id_token_metadata", length = 2000)
  private String oidcIdTokenMetadata;

  @Setter
  @Column(name = "oidc_id_token_claims", length = 2000)
  private String oidcIdTokenClaims;

  @Override
  public void setId(String id) {
    super.setId(id);
  }
}
