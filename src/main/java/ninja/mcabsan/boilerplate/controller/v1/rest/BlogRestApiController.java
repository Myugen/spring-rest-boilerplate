package ninja.mcabsan.boilerplate.controller.v1.rest;

import com.querydsl.core.types.Predicate;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogRestApiController extends RestApiV1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogRestApiController.class);

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getBlogs(@ApiParam @QuerydslPredicate(root = BlogEntity.class) Predicate predicate, @ApiParam(required = true) Pageable pageable) {
        LOGGER.debug("REST Request to get a page of blogs: {predicate={}, pageable: {}", predicate, pageable);
        Page<BlogEntity> blogs = blogService.find(predicate, pageable);
        Page<BlogDTO> result = blogs.map(blogMapper::toDto);
        return ResponseEntity.ok(result.getContent());
    }
}
