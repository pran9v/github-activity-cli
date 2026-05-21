# GitHub Activity CLI

A command-line tool that fetches and displays the recent public activity of any GitHub user, built with Java and Spring Boot.

## Features

Displays recent GitHub events in a human-readable format, including:

- **Pushes** – commits pushed to a repository
- **Repository creation** – new repos created
- **Stars** – repositories starred
- **Forks** – repositories forked
- **Issues** – issue interactions and comments
- **Pull Requests** – PRs opened, updated, or reviewed
- **Releases** – new releases published
- **Deletions** – branches or tags deleted

## Prerequisites

- Java 17+
- Maven (or use the included `mvnw` wrapper)
 
## Getting Started

### Clone the repository

```bash
git clone https://github.com/pran9v/github-activity-cli.git
cd github-activity-cli
```

### Run in development mode

This runs the application directly without creating a JAR:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments=torvalds
```

### Build the application

This creates an executable JAR file:

```bash
./mvnw clean package
```

### Run the packaged application

```bash
java -jar target/github-activity-cli-0.0.1-SNAPSHOT.jar torvalds
```

## Sample Output

```text
Pushed to linux
Starred git
Forked subsystem
Commented on an issue in linux
Worked on a pull request in linux
```

## Tech Stack

- **Java 17**
- **Spring Boot 3** – application framework and CLI runner
- **Spring WebFlux** (`WebClient`) – non-blocking HTTP client for GitHub API calls

## How It Works

1. The app accepts a GitHub username as a command-line argument.
2. It calls the [GitHub Events API](https://docs.github.com/en/rest/activity/events#list-events-for-the-authenticated-user): `GET https://api.github.com/users/{username}/events`
3. Each event is mapped to a readable message and printed to the terminal.

> **Note:** The GitHub Events API is public and does not require authentication, but unauthenticated requests are rate-limited to **60 requests per hour** per IP address.

## Project Structure

```
src/
└── main/java/com/pranav/github_activity_cli/
    ├── GithubActivityCliApplication.java  # Spring Boot entry point
    ├── CliRunner.java                     # Reads CLI args and triggers the service
    ├── GithubService.java                 # Calls GitHub API and formats events
    └── model/
        ├── GithubEvent.java               # Event model
        └── Repo.java                      # Repo model
```

## Inspiration

This project was built as a hands-on exercise from the [roadmap.sh backend projects](https://roadmap.sh/projects/github-user-activity).
