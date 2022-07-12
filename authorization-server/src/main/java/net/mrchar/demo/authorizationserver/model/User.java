package net.mrchar.demo.authorizationserver.model;

import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "`user`")
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractAuditable<User, Long> {
  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  public User() {}

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }
}
