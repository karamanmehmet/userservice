package com.cybertek.userservice.controller;


import com.cybertek.userservice.annotation.DefaultExceptionMessage;
import com.cybertek.userservice.dto.RoleDTO;
import com.cybertek.userservice.entity.ResponseWrapper;
import com.cybertek.userservice.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@Tag(name = "Role Controller",description = "Role API")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @DefaultExceptionMessage(defaultMessage = "Something went wrong,please try again!")
    @Operation(summary = "Read all roles")
    public ResponseEntity<ResponseWrapper> readAll(){
        List<RoleDTO> roleDTOList = roleService.listAllRoles();
        return ResponseEntity.ok(new ResponseWrapper("Successfully retrieved all roles",roleDTOList));

    }


}
