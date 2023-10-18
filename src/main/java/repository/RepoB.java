package repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoB implements RepoInterface {
    public void repoMethod() {
        System.out.println("class (RepoB) method called");
    }
}