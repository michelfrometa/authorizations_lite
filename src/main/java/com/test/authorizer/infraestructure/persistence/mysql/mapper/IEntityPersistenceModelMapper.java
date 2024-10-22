package com.test.authorizer.infraestructure.persistence.mysql.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Contract for an entity to a persistence model mapper.
 *
 * @param <E> - Entity type parameter.
 * @param <P> - Persistence Model type parameter.
 */
public interface IEntityPersistenceModelMapper<E, P> {// FIXME extending beans are not being loaded
    P toPersistenceModel(E entity);

    E toEntity(P persistenceModel);

    List<P> toPersistenceModel(List<E> entityList);

    List<E> toEntity(List<P> persistenceModelList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget P persistenceModel, E entity);
}
