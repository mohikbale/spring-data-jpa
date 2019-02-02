package springbootdatajpaexample.halaqohit.controller;

import springbootdatajpaexample.halaqohit.entity.User;
import springbootdatajpaexample.halaqohit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("users/{userId}")
    @ResponseBody
    public User findUserById(@PathVariable("userId") Long userId) {
        return (User) userRepository.findOne(userId);
    }

    @PutMapping("users/{userId}")
    public User update(@PathVariable("userId") Long userId, @RequestBody User userObject) {
        User user = userRepository.findOne(userId);
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        user.setEmail(userObject.getEmail());
        user.setAddress(userObject.getAddress());
        return userRepository.save(user);
    }

    @DeleteMapping("users/{userId}")
    public List<User> delete(@PathVariable("userId") Long userId) {
        userRepository.delete(userId);
        return userRepository.findAll();
    }

}