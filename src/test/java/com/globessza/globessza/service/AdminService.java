package com.globessza.globessza.service;

import com.globessza.globessza.model.Admin;
import com.globessza.globessza.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public List<Admin> getAll() {
        return repository.findAll();
    }

    public Optional<Admin> getById(Long id) {
        return repository.findById(id);
    }
}