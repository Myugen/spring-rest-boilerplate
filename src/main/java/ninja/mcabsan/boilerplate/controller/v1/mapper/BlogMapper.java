package ninja.mcabsan.boilerplate.controller.v1.mapper;

import ninja.mcabsan.boilerplate.controller.v1.dto.BlogDTO;
import ninja.mcabsan.boilerplate.controller.v1.mapper.common.AbstractGenericMapper;
import ninja.mcabsan.boilerplate.domain.BlogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BlogMapper extends AbstractGenericMapper<BlogEntity, BlogDTO> {

    @Override
    protected BlogEntity newInstance() {
        BlogDTO bb = new BlogDTO();
        return new BlogEntity();
    }
}
