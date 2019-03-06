package cerebrosoft.projection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImprovedUserRepositoryTest {

    @Autowired
    private ImprovedUserRepository repo;

    @Before
    public void setUp() {
        User user1 = new User();
        user1.setId(1l);
        user1.setUsername("jsmith");
        user1.setFullName("John Smith");
        user1.setPasswordHint("my first pet's name");
        user1.setBio("I am likely to be eaten by a grue.");
        repo.save(user1);
    }

    @Test
    public void itShouldGetUser() {
        User user = repo.findById(1l, User.class).get();
        assertThat(user.getUsername()).isEqualTo("jsmith");
        assertThat(user.getFullName()).isEqualTo("John Smith");
        assertThat(user.getPasswordHint()).isEqualTo("my first pet's name");
        assertThat(user.getBio()).isEqualTo("I am likely to be eaten by a grue.");
    }

    @Test
    public void itShouldExternalUserView() {
        ExternalUserView user = repo.findById(1l, ExternalUserView.class).get();
        assertThat(user.getUsername()).isEqualTo("jsmith");
        assertThat(user.getFullName()).isEqualTo("John Smith");
    }

    @Test
    public void itShouldGetInternalUserView() {
        InternalUserView user = repo.findById(1l, InternalUserView.class).get();
        assertThat(user.getUsername()).isEqualTo("jsmith");
        assertThat(user.getFullName()).isEqualTo("John Smith");
        assertThat(user.getBio()).isEqualTo("I am likely to be eaten by a grue.");
    }
    
    @Test
    public void itShouldFindAll() {
        List<InternalUserView> users = repo.findAllBy(InternalUserView.class);
        assertThat(users).hasSize(1);
    }

}
