package cerebrosoft.projection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * This improved version of the repository allows specification of the desired projection 
 * when invoking the query method
 */
public interface ImprovedUserRepository extends CrudRepository<User, Long> {

    /**
     * @param clazz the desired projection class
     * @return a List of T
     */
    <T> List<T> findAllBy(Class<T> clazz);

    /**
     * @param id the user ID
     * @param clazz the desired projection class
     * @return an Optional T
     */
    <T> Optional<T> findById(Long id, Class<T> clazz);

}
