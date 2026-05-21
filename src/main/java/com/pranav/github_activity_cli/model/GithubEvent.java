package com.pranav.github_activity_cli.model;

public class GithubEvent {

    private String type;
    private Repo repo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }
}
