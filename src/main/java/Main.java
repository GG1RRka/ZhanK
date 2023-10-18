import repository.RepoA;
import repository.RepoB;
import repository.RepoC;
import service.ServiceA;
import service.ServiceB;
import service.ServiceC;
import service.ServiceD;
public class Main {
    public static void main(String[] args) {
        RepoA repoA = new RepoA();
        RepoB repoB = new RepoB();
        RepoC repoC = new RepoC();

        ServiceA serviceA = new ServiceA(repoA);
        ServiceB serviceB = new ServiceB(serviceA, repoB);
        ServiceC serviceC = new ServiceC(serviceB, repoC);
        ServiceD serviceD = new ServiceD(serviceC);
        serviceD.methodD();
    }
}