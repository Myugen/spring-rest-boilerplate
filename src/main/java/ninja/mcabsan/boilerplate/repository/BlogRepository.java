package ninja.mcabsan.boilerplate.repository;

import ninja.mcabsan.boilerplate.domain.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long>, QuerydslPredicateExecutor<BlogEntity> {
}
