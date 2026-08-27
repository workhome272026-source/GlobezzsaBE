package com.globessza.globessza.controller;

import com.globessza.globessza.model.Admin;
import com.globessza.globessza.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> save(@RequestBody Admin admin) {
        return ResponseEntity.ok(service.save(admin));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}