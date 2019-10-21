package ninja.mcabsan.boilerplate.service.impl;

import com.querydsl.core.types.Predicate;
import ninja.mcabsan.boilerplate.domain.BlogEntity;
import ninja.mcabsan.boilerplate.error.builder.CustomExceptionBuilder;
import ninja.mcabsan.boilerplate.repository.BlogRepository;
import ninja.mcabsan.boilerplate.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogService.class);

    @Override
    public BlogEntity create(BlogEntity blog) {
        LOGGER.debug("Request to create a blog: {}", blog);
        return save(blog);
    }

    @Override
    public BlogEntity update(BlogEntity blog) {
        LOGGER.debug("Request to update a blog: {}", blog);
        return save(blog);
    }

    @Override
    public Page<BlogEntity> find(Predicate predicate, Pageable pageable) {
        LOGGER.debug("Request to find a blogs: {predicate={}, pageable={}}", predicate, pageable);
        return blogRepository.findAll(predicate, pageable);
    }

    @Override
    public BlogEntity findOne(Long id) {
        LOGGER.debug("Request to get a blog with id: {}", id);
        Optional<BlogEntity> currentBlog = blogRepository.findById(id);
        if (!currentBlog.isPresent()) {
            throw new CustomExceptionBuilder()
                    .message(String.format("Blog with id %s is not found", id))
                    .code("error.entity.notFound")
                    .build();
        }
        return currentBlog.get();
    }

    @Override
    public BlogEntity delete(Long id) {
        LOGGER.debug("Request to delete a blog with id: {}", id);
        BlogEntity blog = findOne(id);
        if (blog.isDeleted()) {
            throw new CustomExceptionBuilder()
                    .message(String.format("The blog with id %s is already deleted, so you can not delete it again", id))
                    .code("error.entity.isDeleted")
                    .build();
        }
        return save(blog);
    }

    @Override
    public BlogEntity recover(Long id) {
        BlogEntity blog = findOne(id);
        if (!blog.isDeleted()) {
            throw new CustomExceptionBuilder()
                    .message(String.format("The blog with id %s is not deleted, so you can not recover it", id))
                    .code("error.entity.isNotDeleted")
                    .build();
        }
        return save(blog);
    }

    private BlogEntity save(BlogEntity blog) {
        LOGGER.debug("Request to save a blog: {}", blog);
        return blogRepository.saveAndFlush(blog);
    }
}
