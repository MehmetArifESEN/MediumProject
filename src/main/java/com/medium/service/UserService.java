package com.medium.service;

import com.medium.dto.request.UserLoginRequestDto;
import com.medium.dto.request.UserRegisterRequestDto;
import com.medium.dto.response.UserLoginResponseDto;
import com.medium.mapper.IUserMapper;
import com.medium.repository.IUserRepository;
import com.medium.repository.entity.User;
import com.medium.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final IUserRepository repository;
    public UserService(IUserRepository repository) {
        super(repository);
        this.repository= repository;
    }
    public User save(UserRegisterRequestDto dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("bu email zaten kullanılıyor");
        } else {
            if (!dto.getPassword().equals(dto.getRePassword())) {
                throw new RuntimeException("Passwordler uyuşmuyor");

            }
            User user = IUserMapper.INSTANCE.fromSaveDto(dto);
            return repository.save(user);
        }
    }

    public UserLoginResponseDto login(UserLoginRequestDto dto) {
        Optional<User> optionalUser = repository.findByEmailIgnoreCaseAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalUser.isEmpty()){
            throw new RuntimeException("Girdiğiniz bilgiler Uyuşmamaktadır");
        }else {
            return IUserMapper.INSTANCE.toLoginResponseDto(optionalUser.get());
        }
    }
}
