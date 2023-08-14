package org.nonit.cashewmanagement.utils.mapper;

import java.util.List;

/**
 * Contract for a generic mapper.
 *
 * @param <E> - Entity type parameter.
 * @param <D> - DTO type parameter.
 */

public interface BaseMapper<E, D> {

    D toDto(E entity);

    List<D> toDtoList(List<E> entityList);
}
