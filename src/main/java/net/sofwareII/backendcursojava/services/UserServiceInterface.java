package net.sofwareII.backendcursojava.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.sofwareII.backendcursojava.shared.dto.UserDTO;

public interface UserServiceInterface extends UserDetailsService{

    public UserDTO createUser (UserDTO userDto);
    
}
