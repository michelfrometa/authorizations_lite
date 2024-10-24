package com.test.authorizer.infraestructure.persistence.mysql.mapper;

import com.test.authorizer.application.mapper.GeneratedMapper;
import com.test.authorizer.domain.model.Transaction;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import com.test.authorizer.infraestructure.persistence.mysql.entity.User;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@AnnotateWith(GeneratedMapper.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICardMySqlMapper extends IDomainModelPersistenceModelMapper<com.test.authorizer.domain.model.Card, Card> {

    com.test.authorizer.domain.model.User toEntity(User user);

    @Mapping(target = "card", ignore = true)
        // fixme This is a workaround, the real problem is in the persistence layer
    Transaction toEntity(com.test.authorizer.infraestructure.persistence.mysql.entity.Transaction source);

}
