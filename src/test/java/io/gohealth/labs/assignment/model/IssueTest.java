package io.gohealth.labs.assignment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class IssueTest {
  private Issue issue;
  private LocalDateTime now;

  @BeforeEach
  void setUp() {
    now = LocalDateTime.now();
    issue = new Issue("1", "https://gohealth.com", "a description", "open", now);
  }

  @Test
  void getIssueId() {
    assertEquals("1", issue.getIssueId());
  }

  @Test
  void getLink() {
    assertEquals("https://gohealth.com", issue.getLink());
  }

  @Test
  void getDescription() {
    assertEquals("a description", issue.getDescription());
  }

  @Test
  void getStatus() {
    assertEquals("open", issue.getStatus());
  }

  @Test
  void getCreatedAt() {
    assertEquals(now, issue.getCreatedAt());
  }
}