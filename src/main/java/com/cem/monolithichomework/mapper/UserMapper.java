package com.cem.monolithichomework.mapper;

import com.cem.monolithichomework.dto.request.LoginRequestDto;
import com.cem.monolithichomework.dto.request.UserSaveRequestDto;
import com.cem.monolithichomework.dto.response.UserFindAllResponseDto;
import com.cem.monolithichomework.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUserFromLogin(final LoginRequestDto dto);

    List<UserFindAllResponseDto> toUserFindAllResponseDto(final List<User> users);

    User toUser(final UserSaveRequestDto requestDto);
}
