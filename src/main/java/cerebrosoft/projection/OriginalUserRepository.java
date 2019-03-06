package cerebrosoft.projection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * This traditional version of the repository uses distinct methods for each projection
 */
public interface OriginalUserRepository extends CrudRepository<User, Long> {

    List<InternalUserView> findAllInternalBy();

    List<ExternalUserView> findAllExternalBy();

    Optional<InternalUserView> findInternalById(Long id);

    Optional<ExternalUserView> findExternalById(Long id);

}
