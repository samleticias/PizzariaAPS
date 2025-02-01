package com.aps.pizzariaapi.service;

import com.aps.pizzariaapi.entity.User;
import com.aps.pizzariaapi.repository.UserRepository;
import com.aps.pizzariaapi.service.exception.UserAlreadyExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) throws UserAlreadyExistsException {
        try {
            this.userRepository.save(user);
            return user;
        } catch (DataIntegrityViolationException e) {
            throw new UserAlreadyExistsException("Nome de usuário já está em uso");
        }
    }
}
