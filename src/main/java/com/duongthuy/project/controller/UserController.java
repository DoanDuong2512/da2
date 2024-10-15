package com.duongthuy.project.controller;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.request.CreateUserRequest;
import com.duong.restful_api.model.request.UpdateUserRequest;
import com.duong.restful_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users=userService.getListUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name="keyword",required = false, defaultValue = "") String keyword) {
        List<UserDto> users = userService.searchUser(keyword);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserRequest req) {
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @Validated @RequestBody UpdateUserRequest req) {
        UserDto result = userService.updateUser(id, req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}

