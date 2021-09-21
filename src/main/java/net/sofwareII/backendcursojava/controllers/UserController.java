package net.sofwareII.backendcursojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sofwareII.backendcursojava.models.request.UserDatailRequestModel;
import net.sofwareII.backendcursojava.models.responses.UserRest;
import net.sofwareII.backendcursojava.shared.dto.UserDTO;


@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "Obtener usuarios";
    }
    
    @PostMapping
    public UserRest CreateUser(@RequestBody UserDatailRequestModel userDatails){
        UserRest userToReturn =new UserRest();

        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userDatails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);

        BeanUtils.copyProperties(createdUser, userToReturn);


        return null;
    }
        

}
