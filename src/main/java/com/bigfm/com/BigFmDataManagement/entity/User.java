package com.bigfm.com.BigFmDataManagement.entity;


import com.bigfm.com.BigFmDataManagement.domain.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String username;

    String address;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserDTO getUserDto(){

        UserDTO userDTO=new UserDTO();
        userDTO.setAdd(address);
        userDTO.setId(id);
        userDTO.setUsername(username);
        return userDTO;
    }
}
