package com.cybertek.userservice.service;

import com.cybertek.userservice.dto.RoleDTO;
import com.cybertek.userservice.exception.TicketingProjectException;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id) throws TicketingProjectException;
}
