package com.example.demo.repository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoA implements RepoInterface {
    @Override
    public void repoMethod() {
        System.out.println("class (RepoA) method called");
    }
}