package com.test.authorizer.application.usecase.user.mapper;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.mapper.IEntityMapper;
import com.test.authorizer.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper extends IEntityMapper<UserDto, User> {

    User toEntity(CreateUserDto entity);

    UserDto toDto(User entity);

}
