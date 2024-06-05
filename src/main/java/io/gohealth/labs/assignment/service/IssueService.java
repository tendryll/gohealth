package io.gohealth.labs.assignment.service;

import io.gohealth.labs.assignment.model.Issue;
import org.springframework.stereotype.Service;

public interface IssueService {
  Issue createIssue(String issueId, String link, String description);

  Issue deleteIssue(String issueId);
}
