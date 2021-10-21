package net.sofwareII.backendcursojava.services;

import java.util.ArrayList;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.sofwareII.backendcursojava.UserRepository;
import net.sofwareII.backendcursojava.entities.UserEntity;
import net.sofwareII.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface {

    
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        
        if (userRepository.findUserByEmail(userDto.getEmail())!=null) 
        throw new RuntimeException("El E-mail ya existe");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());
        
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetail = userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDetail, userToReturn);
        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        UserEntity userEntity = userRepository.findUserByEmail(email);
        
        if(userEntity == null){
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());

    }

}
