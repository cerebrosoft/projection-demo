package cerebrosoft.projection;

/**
 * A view of a user visible to out-of-network users
 */
public interface ExternalUserView {

    Long getId();

    String getUsername();

    String getFullName();

}
