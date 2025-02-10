package com.EventManagement.demo.services;

import com.EventManagement.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    HashMap<String, List<User>> users = new HashMap<>();

    private long nextId= 1L;

    public HashMap<String, List<User>> getAllUsers(){
        return this.users;
    }

    public User newUser(User user, String eventName){
        user.setId(this.nextId++);
        if(this.users.containsKey(eventName))
            this.users.get(eventName).add(user);

        else{
            this.users.put(eventName, new ArrayList<User>());
            this.users.get(eventName).add(user);
        }
        return user;
    }

    public List<User> getUsersByEvent(String event){
        return this.users.get(event);
    }

    public void cancelReservation(String email){

        int index = -1;
        for(List<User> users: this.users.values()){
            for(User user: users){

                if(user.getEmail().equals(email)){
                     index = users.indexOf(user);
                     break;

                }
            }
            if(index != -1){
                users.remove(index);
            }


        }

    }
}
