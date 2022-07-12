package net.mrchar.demo.authorizationserver.service;

import net.mrchar.demo.authorizationserver.model.User;
import net.mrchar.demo.authorizationserver.repository.LocalUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsServiceImpl implements UserDetailsService {
  private final LocalUserRepository localUserRepository;

  public JpaUserDetailsServiceImpl(LocalUserRepository localUserRepository) {
    this.localUserRepository = localUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.localUserRepository.findOneByName(username);
    return this.toObject(user);
  }

  private UserDetails toObject(User user) {
    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getName())
        .password(user.getPassword())
        .roles(new String[] {})
        .build();
  }
}
