package repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoC implements RepoInterface {
    public void repoMethod() {
        System.out.println("class (RepoC) method called");
    }
}