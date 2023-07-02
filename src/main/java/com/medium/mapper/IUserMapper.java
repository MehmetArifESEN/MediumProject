package com.medium.mapper;

import com.medium.dto.request.UserLoginRequestDto;
import com.medium.dto.request.UserRegisterRequestDto;
import com.medium.dto.response.UserLoginResponseDto;
import com.medium.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
    User fromSaveDto(UserRegisterRequestDto dto);
    UserLoginResponseDto toLoginResponseDto(User user);
}
