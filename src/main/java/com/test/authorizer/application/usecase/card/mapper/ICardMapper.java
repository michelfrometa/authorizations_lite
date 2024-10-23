package com.test.authorizer.application.usecase.card.mapper;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.mapper.GeneratedMapper;
import com.test.authorizer.application.mapper.IEntityMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@AnnotateWith(GeneratedMapper.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICardMapper extends IEntityMapper<CardDto, Card> {

    Card toEntity(CreateCardDto createCardDto);

    com.test.authorizer.application.input.card.CardBalanceOnlyDto toDto(CardBalanceOnlyDto cardBalanceOnlyDto);
}
