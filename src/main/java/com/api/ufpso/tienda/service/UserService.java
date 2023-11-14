package com.api.ufpso.tienda.service;

import com.api.ufpso.tienda.exception.NotFoundException;
import com.api.ufpso.tienda.model.User;
import com.api.ufpso.tienda.repository.UserRepository;
import com.api.ufpso.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User userReq) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(userReq.getPassword());
        userReq.setPassword(encryptedPassword);

        return userRepository.save(userReq);
    }
    public User getUserById(Long id){
        if(id == null)
        {
            throw new NotFoundException(Constants.USER_IS_NULL.getMessage());
        }
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND.getMessage());
        }
        return user.get();
    }
    public User updateUser(User userReq, Long id){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND.getMessage());
        }
        userBd.get().setFirstName(userReq.getFirstName());
        userBd.get().setLastName(userReq.getLastName());
        userBd.get().setPhone(userReq.getPhone());
        userBd.get().setDocument(userReq.getDocument());
        return userRepository.save(userBd.get());
    }
    public boolean deleteUser(Long id){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND.getMessage());
        }
        userRepository.delete(userBd.get());
        return true;
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findOneByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("El usuario con email " + email + " no existe.");
        }

        User user = userOptional.get();
        return new UserDetailsImpl(user);
    }


}