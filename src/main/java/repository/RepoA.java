package repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoA {
    public void methodA() {
        System.out.println("class (RepoA) method called");
    }
}