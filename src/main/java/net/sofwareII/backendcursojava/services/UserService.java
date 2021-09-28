package net.sofwareII.backendcursojava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sofwareII.backendcursojava.UserRepository;
import net.sofwareII.backendcursojava.entities.UserEntity;
import net.sofwareII.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface {

    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword("testpassword");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetail = userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDetail, userToReturn);
        return userToReturn;
    }

}
