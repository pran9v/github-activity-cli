package com.pranav.github_activity_cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {

    private final GithubService githubService;

    public CliRunner(GithubService githubService) {
        this.githubService = githubService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("Error: No username was provided");
            return;
        }
        String events = githubService.getGithubInfo(args[0]);
        System.out.println(events);
    }
}
