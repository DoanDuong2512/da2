package com.duongthuy.project.service;

import com.duongthuy.project.dto.UserDto;
import com.duongthuy.project.dto.request.RegisterCustomerRequest;
import com.duongthuy.project.dto.request.RegisterSupplierRequest;
import com.duongthuy.project.dto.request.UpdateCustomerRequest;
import com.duongthuy.project.dto.request.UpdateSupplierRequest;
import com.duongthuy.project.dto.response.ErrorResponseDto;
import com.duongthuy.project.entity.Role;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.repository.RoleRepository;
import com.duongthuy.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    public ErrorResponseDto registerCustomer(RegisterCustomerRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());

        Role role = roleRepository.findByRoleCode("CUS").orElse(null);
        if(role == null){
            throw new RuntimeException("Role not found");
        }
        user.setRole(role);
        userRepository.save(user);

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Register successfully");
        errorResponseDto.setErrorCode("00");
        errorResponseDto.setSuccess(true);
        return errorResponseDto;
    }

    public ErrorResponseDto registerSupplier(RegisterSupplierRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setContactInfo(request.getContactInfo());
        user.setSupplierAddress(request.getSupplierAddress());
        user.setSupplierType(request.getSupplierType());
        user.setSupplierAddress(request.getSupplierAddress());
        Role role = roleRepository.findByRoleCode("SUP").orElse(null);
        if(role == null){
            throw new RuntimeException("Role not found");
        }
        user.setRole(role);
        userRepository.save(user);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Register successfully");
        errorResponseDto.setErrorCode("00");
        errorResponseDto.setSuccess(true);
        return errorResponseDto;
    }

    public UserDto findUserById(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public List<UserDto> findUserByRoleCode(String roleCode){
        List<User> users = userRepository.findUserByRoleCode(roleCode);
        List<UserDto> userDtoList = users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
        return userDtoList;
    }

    public ErrorResponseDto updateCustomer(UpdateCustomerRequest updateCustomerRequest, Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return new ErrorResponseDto(false, "User not found", "01");
        }
        user.setFullName(updateCustomerRequest.getFullName());
        user.setPhone(updateCustomerRequest.getPhone());
        user.setEmail(updateCustomerRequest.getEmail());
        userRepository.save(user);
        return new ErrorResponseDto(true, "Update successfully", "00");
    }

    public ErrorResponseDto updateSupplier(UpdateSupplierRequest updateSupplierRequest, Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return new ErrorResponseDto(false, "User not found", "01");
        }
        user.setFullName(updateSupplierRequest.getFullName());
        user.setPhone(updateSupplierRequest.getPhone());
        user.setEmail(updateSupplierRequest.getEmail());
        user.setContactInfo(updateSupplierRequest.getContactInfo());
        user.setSupplierAddress(updateSupplierRequest.getSupplierAddress());
        user.setSupplierType(updateSupplierRequest.getSupplierType());
        userRepository.save(user);
        return new ErrorResponseDto(true, "Update successfully", "00");
    }

    public ErrorResponseDto deleteUser(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return new ErrorResponseDto(false, "User not found", "01");
        }
        userRepository.delete(user);
        return new ErrorResponseDto(true, "Delete successfully", "00");
    }
}
