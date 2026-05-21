package com.pranav.github_activity_cli;

import com.pranav.github_activity_cli.model.GithubEvent;
import com.pranav.github_activity_cli.model.Repo;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GithubService {

    public String getGithubInfo(String username) {
        WebClient webClient = WebClient.create("https://api.github.com");
        GithubEvent[] events = webClient
            .get()
            .uri("/users/{username}/events", username)
            .retrieve()
            .bodyToMono(GithubEvent[].class)
            .block();

        if (
            events == null || events.length == 0
        ) return "Error: Enter the valid username";

        ArrayList<String> formattedEvents = new ArrayList<>();

        for (GithubEvent event : events) {
            String type = event.getType();
            Repo repo = event.getRepo();

            if (type.equals("PushEvent")) {
                formattedEvents.add("Pushed to " + repo.getName());
            } else if (type.equals("CreateEvent")) {
                formattedEvents.add("Created the repo " + repo.getName());
            } else if (type.equals("WatchEvent")) {
                formattedEvents.add("Starred " + repo.getName());
            } else if (type.equals("ForkEvent")) {
                formattedEvents.add("Forked " + repo.getName());
            } else if (type.equals("IssueCommentEvent")) {
                formattedEvents.add(
                    "Commented on an issue in " + repo.getName()
                );
            } else if (type.equals("IssuesEvent")) {
                formattedEvents.add(
                    "Interacted with an issue in " + repo.getName()
                );
            } else if (type.equals("PullRequestEvent")) {
                formattedEvents.add(
                    "Worked on a pull request in " + repo.getName()
                );
            } else if (type.equals("PullRequestReviewEvent")) {
                formattedEvents.add(
                    "Reviewed a pull request in " + repo.getName()
                );
            } else if (type.equals("DeleteEvent")) {
                formattedEvents.add("Deleted something in " + repo.getName());
            } else if (type.equals("ReleaseEvent")) {
                formattedEvents.add("Published a release in " + repo.getName());
            } else {
                formattedEvents.add(
                    "Performed " + type + " in " + repo.getName()
                );
            }
        }

        return String.join("\n", formattedEvents);
    }
}
