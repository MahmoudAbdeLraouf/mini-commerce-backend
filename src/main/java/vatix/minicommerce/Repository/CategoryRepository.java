package vatix.minicommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vatix.minicommerce.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
