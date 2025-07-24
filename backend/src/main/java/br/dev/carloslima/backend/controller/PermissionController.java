package br.dev.carloslima.backend.controller;

import br.dev.carloslima.backend.model.PermissionModel;
import br.dev.carloslima.backend.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @GetMapping
    public ResponseEntity<List<PermissionModel>> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
