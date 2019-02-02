package springbootdatajpaexample.halaqohit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootdatajpaexample.halaqohit.entity.User2;
import springbootdatajpaexample.halaqohit.repository.User2Repository;

import java.util.List;

@RestController
@RequestMapping("api")
public class User2Controller {
    @Autowired
    User2Repository user2Repository;

    @PostMapping("jajanan")
    public User2 create(@RequestBody User2 user2){
        return user2Repository.save(user2);
    }

    @GetMapping("jajanan")
    public List<User2> findAll(){
        return user2Repository.findAll();
    }

    @GetMapping("jajanan/{user2Id}")
    @ResponseBody
    public User2 findUserById(@PathVariable("user2Id") Long user2Id) {
        return (User2) user2Repository.findOne(user2Id);
    }

    @PutMapping("jajanan/{user2Id}")
    public User2 update(@PathVariable("user2Id") Long user2Id, @RequestBody User2 userObject) {
        User2 user = user2Repository.findOne(user2Id);
        user.setName(userObject.getName());
        user.setHarga(userObject.getHarga());
        return user2Repository.save(user);
    }

    @DeleteMapping("jajanan/{user2Id}")
    public List<User2> delete(@PathVariable("user2Id") Long user2Id) {
        user2Repository.delete(user2Id);
        return user2Repository.findAll();
    }

}
