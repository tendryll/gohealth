package io.gohealth.labs.assignment.repository;

import io.gohealth.labs.assignment.model.Issue;

import java.io.FileNotFoundException;

public interface IssueRepository {
  Issue createIssue(Issue issue) throws FileNotFoundException;

  Issue deleteIssue(String issueId);
}
