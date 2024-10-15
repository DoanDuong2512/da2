package com.duongthuy.project.service;

import com.duong.restful_api.entity.User;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.request.CreateUserRequest;
import com.duong.restful_api.model.request.UpdateUserRequest;
import com.duong.restful_api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getListUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(modelMapper.map(user, UserDto.class));
        }
        return result;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> searchUser(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(modelMapper.map(user, UserDto.class));
        }
        return result;
    }

    public UserDto createUser(CreateUserRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setContactInfo(req.getContactInfo());
        user.setPassword(req.getPassword());
        user.setFullName(req.getFullName());
        // Ensure you have a role in the CreateUserRequest
        user.setRole(req.getRole());
        user.setSupplierType(req.getSupplierType());
        user.setSupplierIntro(req.getSupplierIntro());
        user.setSupplierAddress(req.getSupplierAddress());
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUser(Long id, UpdateUserRequest req) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setContactInfo(req.getContactInfo());
        user.setPassword(req.getPassword());
        user.setFullName(req.getFullName());
        user.setRole(req.getRole());
        user.setSupplierType(req.getSupplierType());
        user.setSupplierIntro(req.getSupplierIntro());
        user.setSupplierAddress(req.getSupplierAddress());
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        userRepository.delete(user);
    }
}
