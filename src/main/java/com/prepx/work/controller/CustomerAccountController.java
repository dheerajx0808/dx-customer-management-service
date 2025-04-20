package com.prepx.work.controller;


import com.prepx.work.entity.CustomerAccount;
import com.prepx.work.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class CustomerAccountController {

    private final CustomerAccountService service;

    @Autowired
    public CustomerAccountController(CustomerAccountService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomerAccount> getUserById(@PathVariable Long userId) {
        Optional<CustomerAccount> user = service.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerAccount>> getAllUsers(@RequestParam("lastModifiedDate")
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                             LocalDateTime lastModifiedDate) {
        List<CustomerAccount> users = service.getAllUsersModifiedAfter(lastModifiedDate);
        return ResponseEntity.ok(users);
    }
}
