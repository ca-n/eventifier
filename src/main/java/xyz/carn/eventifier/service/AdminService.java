package xyz.carn.eventifier.service;

import org.springframework.stereotype.Service;
import xyz.carn.eventifier.model.Admin;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.repository.AdminRepository;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Optional<Admin> login(User credentials) {

    }
}
