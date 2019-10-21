package ninja.mcabsan.boilerplate.service;

import com.querydsl.core.types.Predicate;
import ninja.mcabsan.boilerplate.domain.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    public BlogEntity create(BlogEntity blog);

    public BlogEntity update(BlogEntity blog);

    public Page<BlogEntity> find(Predicate predicate, Pageable pageable);

    public BlogEntity findOne(Long id);

    public BlogEntity delete(Long id);

    public BlogEntity restore(Long id);
}
