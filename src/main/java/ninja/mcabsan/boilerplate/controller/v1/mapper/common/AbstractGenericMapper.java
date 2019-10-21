package ninja.mcabsan.boilerplate.controller.v1.mapper.common;

import ninja.mcabsan.boilerplate.controller.v1.dto.common.AbstractAuditingDTO;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractGenericMapper<E, D extends AbstractAuditingDTO> {

    @Autowired
    private JpaRepository<E, Long> repository;

    @ObjectFactory
    public E toEntity(D dto) {
        E entity = dto.getId() != null ? repository.findById(dto.getId()).get() : newInstance();
        mapTo(entity, dto);
        return entity;
    }

    protected abstract E newInstance();

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    public abstract void mapTo(@MappingTarget E entity, D dto);

    public abstract D toDto(E entity);

    public abstract List<D> toDto(List<E> entities);
}
