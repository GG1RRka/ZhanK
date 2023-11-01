package com.example.demo.repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoB implements RepoInterface {
    @Override
    public void repoMethod() {
        System.out.println("class (RepoB) method called");
    }
}