package io.gohealth.labs.assignment.model;

import java.time.LocalDateTime;

public class Issue {
  private String issueId;
  private String link;
  private String description;
  private String status;
  private LocalDateTime createdAt;

  public Issue(final String issueId, final String link, final String description, final String status,
               final LocalDateTime createdAt) {
    this.issueId = issueId;
    this.link = link;
    this.description = description;
    this.status = status;
    this.createdAt = createdAt;
  }

  public String getIssueId() {
    return issueId;
  }

  public String getLink() {
    return link;
  }

  public String getDescription() {
    return description;
  }

  public String getStatus() {
    return status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
