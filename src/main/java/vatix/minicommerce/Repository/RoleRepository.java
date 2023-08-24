package vatix.minicommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vatix.minicommerce.Model.ERole;
import vatix.minicommerce.Model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	  Optional<Role> findByName(ERole name);

}
