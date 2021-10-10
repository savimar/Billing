package ru.savimar.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savimar.billing.entity.Bill;
import ru.savimar.billing.entity.User;
import ru.savimar.billing.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        List<User> result = repository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
      }


    public void delete(Integer id){
        repository.deleteById(id);
    }

    public User save(User user){
      return repository.save(user);
    }


    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow();
    }


}
