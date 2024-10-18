package com.duongthuy.project.controller;
import com.duongthuy.project.dto.UserDto;
import com.duongthuy.project.dto.request.*;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.dto.response.LoginResponse;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable(name="id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public List<UserDto> findUserByRoleCode(@RequestParam(name="roleCode") String roleCode){
        return userService.findUserByRoleCode(roleCode);
    }

    @PostMapping("/register-customer")
    public ResponseEntity<ErrorResponseDto> registerCustomer(@RequestBody RegisterCustomerRequest request){
        return ResponseEntity.ok(userService.registerCustomer(request));
    }

    @PostMapping("/register-supplier")
    public ResponseEntity<ErrorResponseDto> registerSupplier(@RequestBody RegisterSupplierRequest request){
        return ResponseEntity.ok(userService.registerSupplier(request));
    }

    @PutMapping("/update-customer/{id}")
    public ResponseEntity<ErrorResponseDto> updateCustomer(@RequestBody UpdateCustomerRequest request,
                                                           @PathVariable(name="id") Integer id){
        return ResponseEntity.ok(userService.updateCustomer(request, id));
    }

    @PutMapping("/update-supplier/{id}")
    public ResponseEntity<ErrorResponseDto> updateSupplier(@RequestBody UpdateSupplierRequest request,
                                                           @PathVariable(name="id") Integer id){
        return ResponseEntity.ok(userService.updateSupplier(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ErrorResponseDto> delete(@PathVariable(name="id") Integer id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.authenticate(request));
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }
}

