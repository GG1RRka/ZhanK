package repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoB {
    public void methodB() {
        System.out.println("class (RepoB) method called");
    }
}