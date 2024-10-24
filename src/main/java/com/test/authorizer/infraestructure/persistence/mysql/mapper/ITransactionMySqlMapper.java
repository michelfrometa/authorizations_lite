package com.test.authorizer.infraestructure.persistence.mysql.mapper;

import com.test.authorizer.application.mapper.GeneratedMapper;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Transaction;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@AnnotateWith(GeneratedMapper.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ITransactionMySqlMapper extends IDomainModelPersistenceModelMapper<com.test.authorizer.domain.model.Transaction, Transaction> {

    com.test.authorizer.domain.model.Card toEntity(Card card);

    @Named("tricked")
    @Mapping(target = "transactions", ignore = true)
    Card toPersistenceModelTricked(com.test.authorizer.domain.model.Card card);

    @Named("tricked")
    @Mapping(target = "card", expression = "java(toPersistenceModelTricked(entity.getCard()))")
    Transaction toPersistenceModelTricked(com.test.authorizer.domain.model.Transaction entity);
}
