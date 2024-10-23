package com.test.authorizer.infraestructure.persistence.mysql.mapper;

import com.test.authorizer.application.mapper.GeneratedMapper;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Transaction;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@AnnotateWith(GeneratedMapper.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ITransactionMySqlMapper extends IEntityPersistenceModelMapper<com.test.authorizer.domain.model.Transaction, Transaction> {

}