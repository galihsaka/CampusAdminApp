package com.enigmacamp.campusadminapp.service;

import com.enigmacamp.campusadminapp.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getOrSave(List<Role.ERole> roles);
}
