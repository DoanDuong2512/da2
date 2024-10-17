package com.duongthuy.project.controller;
import com.duongthuy.project.dto.UserDto;
import com.duongthuy.project.dto.request.RegisterCustomerRequest;
import com.duongthuy.project.dto.request.RegisterSupplierRequest;
import com.duongthuy.project.dto.request.UpdateCustomerRequest;
import com.duongthuy.project.dto.request.UpdateSupplierRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

}

