package com.test.authorizer.application.usecase.user.mapper;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.mapper.GeneratedMapper;
import com.test.authorizer.application.mapper.IEntityMapper;
import com.test.authorizer.domain.model.User;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@AnnotateWith(GeneratedMapper.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper extends IEntityMapper<UserDto, User> {

    User toEntity(CreateUserDto entity);

}
