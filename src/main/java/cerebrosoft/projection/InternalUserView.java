package cerebrosoft.projection;

/**
 * A view of a user visible to in-network users
 */
public interface InternalUserView {

    Long getId();

    String getUsername();

    String getFullName();

    String getBio();
}
