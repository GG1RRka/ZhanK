package repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoA implements RepoInterface {
    public void repoMethod() {
        System.out.println("class (RepoA) method called");
    }
}