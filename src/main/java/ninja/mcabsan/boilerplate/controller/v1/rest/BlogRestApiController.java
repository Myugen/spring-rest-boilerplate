package ninja.mcabsan.boilerplate.controller.v1.rest;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import ninja.mcabsan.boilerplate.controller.v1.dto.BlogDTO;
import ninja.mcabsan.boilerplate.controller.v1.mapper.BlogMapper;
import ninja.mcabsan.boilerplate.controller.v1.rest.common.RestApiV1Controller;
import ninja.mcabsan.boilerplate.domain.BlogEntity;
import ninja.mcabsan.boilerplate.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@Api("Blog API Documentation")
public class BlogRestApiController extends RestApiV1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogRestApiController.class);

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogMapper blogMapper;

    @PostMapping
    public ResponseEntity<BlogDTO> create(@RequestBody BlogDTO blogDTO) throws URISyntaxException {
        LOGGER.debug("REST request to create a blog: {}", blogDTO);
        BlogEntity blog = blogMapper.toEntity(blogDTO);
        BlogEntity createdBlog = blogService.create(blog);
        BlogDTO result = blogMapper.toDto(createdBlog);
        return ResponseEntity.created(new URI("/api/v1/blogs")).body(result);
    }

    @PutMapping
    public ResponseEntity<BlogDTO> update(@RequestBody BlogDTO blogDTO) {
        LOGGER.debug("REST request to update a blog: {}", blogDTO);
        BlogEntity blog = blogMapper.toEntity(blogDTO);
        BlogEntity updatedBlog = blogService.update(blog);
        BlogDTO result = blogMapper.toDto(updatedBlog);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<BlogDTO>> find(@ApiParam @QuerydslPredicate(root = BlogEntity.class) Predicate predicate, @ApiParam(required = true) Pageable pageable) {
        LOGGER.debug("REST request to get a page of blogs: {predicate={}, pageable: {}", predicate, pageable);
        Page<BlogEntity> blogs = blogService.find(predicate, pageable);
        Page<BlogDTO> result = blogs.map(blogMapper::toDto);
        return ResponseEntity.ok(result.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getOne(@ApiParam @PathVariable Long id) {
        LOGGER.debug("REST request to get a blog: {}", id);
        BlogEntity blog = blogService.findOne(id);
        BlogDTO result = blogMapper.toDto(blog);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BlogDTO> delete(@ApiParam @PathVariable Long id) {
        LOGGER.debug("REST request to delete a blog: {}", id);
        BlogEntity deletedBlog = blogService.delete(id);
        BlogDTO result = blogMapper.toDto(deletedBlog);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<BlogDTO> restore(@ApiParam @PathVariable Long id) {
        LOGGER.debug("REST request to restore a blog: {}", id);
        BlogEntity restoredBlog = blogService.restore(id);
        BlogDTO result = blogMapper.toDto(restoredBlog);
        return ResponseEntity.ok(result);
    }
}
