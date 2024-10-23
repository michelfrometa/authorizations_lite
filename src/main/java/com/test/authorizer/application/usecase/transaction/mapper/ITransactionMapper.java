package com.test.authorizer.application.usecase.transaction.mapper;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;
import com.test.authorizer.application.mapper.GeneratedMapper;
import com.test.authorizer.application.mapper.IEntityMapper;
import com.test.authorizer.domain.model.Transaction;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@AnnotateWith(GeneratedMapper.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ITransactionMapper extends IEntityMapper<TransactionDto, Transaction> {

    Transaction toEntity(CreateTransactionDto entity);

}
