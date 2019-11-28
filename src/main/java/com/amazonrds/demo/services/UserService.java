package com.amazonrds.demo.services;
import com.amazonrds.demo.models.User;
import com.amazonrds.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserService {

private UserRepository repository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> getAllUsers(){

        List<User> users = repository.findAllByOrderByNameAsc();

        return users;
    }

    public void addUser (String name, String lastname){
        User user =  new User();
        user.setName(name);
        user.setLastname(lastname);
        repository.save(user);
    }

}
