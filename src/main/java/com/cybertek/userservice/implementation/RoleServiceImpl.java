package com.cybertek.userservice.implementation;


import com.cybertek.userservice.dto.RoleDTO;
import com.cybertek.userservice.entity.Role;
import com.cybertek.userservice.exception.TicketingProjectException;
import com.cybertek.userservice.repository.RoleRepository;
import com.cybertek.userservice.service.RoleService;
import com.cybertek.userservice.util.MapperUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;
    private MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list = roleRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj,new RoleDTO())).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) throws TicketingProjectException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new TicketingProjectException("Role does not exists"));
        return mapperUtil.convert(role,new RoleDTO());
    }
}
