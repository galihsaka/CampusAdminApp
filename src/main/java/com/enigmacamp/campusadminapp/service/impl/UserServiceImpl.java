package com.enigmacamp.campusadminapp.service.impl;

import com.enigmacamp.campusadminapp.entity.AppUser;
import com.enigmacamp.campusadminapp.entity.Role;
import com.enigmacamp.campusadminapp.entity.User;
import com.enigmacamp.campusadminapp.repository.UserRepository;
import com.enigmacamp.campusadminapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid credential user"));
        List<Role.ERole> roleName=new ArrayList<>();
        for(int i=0;i<user.getRoles().size();i++){
            roleName.add(user.getRoles().get(i).getName());
        }
        AppUser appUser=new AppUser();
        appUser.setId(user.getId());
        appUser.setUsername(user.getUsername());
        appUser.setPassword(user.getPassword());
        appUser.setRole(roleName);
        return appUser;
    }
}
