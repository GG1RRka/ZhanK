package com.example.demo.repository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepoC implements RepoInterface {
    @Override
    public void repoMethod() {
        System.out.println("class (RepoC) method called");
    }
}