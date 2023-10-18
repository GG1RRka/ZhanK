package repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoC {
    public void repoMethodC() {
        System.out.println("class (RepoC) method called");
    }
}