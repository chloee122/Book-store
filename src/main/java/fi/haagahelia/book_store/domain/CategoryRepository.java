package fi.haagahelia.book_store.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByCategoryId(Long categoryId);
}
