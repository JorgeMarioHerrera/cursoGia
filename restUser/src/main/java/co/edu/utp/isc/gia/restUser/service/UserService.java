/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restUser.service;

import co.edu.utp.isc.gia.restUser.data.entity.User;
import co.edu.utp.isc.gia.restUser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restUser.web.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author mario
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper mapper;

    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    public UserDTO save(UserDTO user) {
        user.setUsername(user.getUsername().toLowerCase());
        User myUser = mapper.map(user, User.class);
        myUser = userRepository.save(myUser);
        UserDTO res = mapper.map(myUser, UserDTO.class);
        return res;

    }

    public List<UserDTO> listAll() {
        List<UserDTO> dto = new ArrayList<>();
        Iterable<User> entity = userRepository.findAll();
        if (entity != null) {
            for (User user : entity) {
                dto.add(mapper.map(user, UserDTO.class));
            }
            return dto;
        }
        return null;
    }

    public UserDTO findOne(Long id) {
        Optional<User> entity = userRepository.findById(id);
        
        if (entity != null) {
            UserDTO res = mapper.map(entity.get(), UserDTO.class);
            return res;
        }
        return null;
    }
    
    
    public String deleteById(Long id) {
        Optional<User> entity = userRepository.findById(id);
        if (entity.isPresent()) {
            this.userRepository.deleteById(id);
            return ("Borrado");
        }
        return null;
    }
    
    
}
