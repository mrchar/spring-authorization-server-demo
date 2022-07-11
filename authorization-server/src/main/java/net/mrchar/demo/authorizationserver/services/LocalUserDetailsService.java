package net.mrchar.demo.authorizationserver.services;

import net.mrchar.demo.authorizationserver.repository.LocalUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LocalUserDetailsService implements UserDetailsService {
  private final LocalUserRepository localUserRepository;

  public LocalUserDetailsService(LocalUserRepository localUserRepository) {
    this.localUserRepository = localUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.localUserRepository.findOneByName(username);

  }
}
