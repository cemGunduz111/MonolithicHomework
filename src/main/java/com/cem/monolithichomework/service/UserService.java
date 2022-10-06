package com.cem.monolithichomework.service;

import com.cem.monolithichomework.dto.request.UserSaveRequestDto;
import com.cem.monolithichomework.dto.response.UserFindAllResponseDto;
import com.cem.monolithichomework.exception.ErrorType;
import com.cem.monolithichomework.exception.MonolithicHomeworkManagerException;
import com.cem.monolithichomework.mapper.UserMapper;
import com.cem.monolithichomework.repository.IUserRepository;
import com.cem.monolithichomework.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public  User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }


    public Optional<User> login (String username, String password){
        Optional<User> user = userRepository.findOptionalByUsernameAndPassword(username, password);
        if (user.isEmpty()){
            System.out.println("Kullanıcı Bulunamadı");
            return Optional.ofNullable(null);
        }
        return user;
    }
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<UserFindAllResponseDto> findAllDto() {
        return UserMapper.INSTANCE.toUserFindAllResponseDto(userRepository.findAll());
    }

    public User saveRequestDto(UserSaveRequestDto saveDto){

        try {
            User user = UserMapper.INSTANCE.toUser(saveDto);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new MonolithicHomeworkManagerException(ErrorType.USER_NOT_CREATED,"Kullanıcı oluşturulamadı");
        }
    }
}
