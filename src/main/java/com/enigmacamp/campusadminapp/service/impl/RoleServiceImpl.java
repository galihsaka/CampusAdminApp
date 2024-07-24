package com.enigmacamp.campusadminapp.service.impl;

import com.enigmacamp.campusadminapp.entity.Role;
import com.enigmacamp.campusadminapp.repository.RoleRepository;
import com.enigmacamp.campusadminapp.service.RoleService;
import com.enigmacamp.campusadminapp.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getOrSave(List<Role.ERole> roles) {
        List<Role> roleList=new ArrayList<>();
        for(int i=0;i< roles.size();i++){
            Optional<Role> optionalRole = roleRepository.findByName(roles.get(i).name());
            if (optionalRole.isEmpty()) {
                Role roleSaved=new Role();
                roleSaved.setName(roles.get(i));
                roleRepository.save(roleSaved);
            }
        }
        for(int j=0;j< roles.size();j++){
            Optional<Role> optionalRole = roleRepository.findByName(roles.get(j).name());
            Role newRole=optionalRole.orElseThrow(()->new ResourceNotFoundException("Role Not Found"));
            roleList.add(newRole);
        }
        return roleList;

    }
}
