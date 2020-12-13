package com.example.java.four;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class IssueCalculator {

  private String token = "토큰값";
  private static final String WHITESHIP = "whiteship/live-study";
  private static final int CONTENTS_NUMBER = 18;

  public void start() throws IOException {
    HashMap<String, Integer> peopleCount = new HashMap<>();

    GitHub certifiedGitHub = authenticate();
    countPeople(certifiedGitHub, peopleCount);
    calculatePartitionRate(peopleCount);
  }

  private GitHub authenticate() throws IOException {
    System.out.println("----인증");
    return new GitHubBuilder().withOAuthToken(token).build();
  }

  private void countPeople(GitHub gitHub, HashMap<String, Integer> peopleCount) throws IOException {
    for (int issueId = 1; issueId <= CONTENTS_NUMBER; issueId++) {
      List<GHIssueComment> issues = getCommentsByRepositoryAndIssue(gitHub, WHITESHIP, issueId);
      for (GHIssueComment issueComment : issues) {
        String loginUser = issueComment.getUser().getLogin();
        Integer count = peopleCount.get(loginUser);
        peopleCount.put(loginUser, count == null ? 1 : ++count);
      }
    }
  }

  private void calculatePartitionRate(HashMap<String, Integer> peopleCount) {
    System.out.println("---------------------------------------------");
    peopleCount.forEach((name, count) -> {
      System.out.printf("%s %.2f%%", name, Math.round((count * 10000)) / (CONTENTS_NUMBER * 100.0) );
      System.out.println();
      System.out.println("---------------------------------------------");
    });
  }


  private List<GHIssueComment> getCommentsByRepositoryAndIssue(GitHub gitHub,
      String repositoryName, int issueId)
      throws IOException {
    System.out.println("----이슈 연결 " + issueId + "번째");
    return gitHub.getRepository(repositoryName).getIssue(issueId)
        .getComments();
  }

}
