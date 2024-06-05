package io.gohealth.labs.assignment.service.impl;

import io.gohealth.labs.assignment.model.Issue;
import io.gohealth.labs.assignment.repository.IssueRepository;
import io.gohealth.labs.assignment.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class CsvIssueServiceImpl implements IssueService {
  @Autowired
  private IssueRepository issueRepository;

  @Override
  public Issue createIssue(String issueId, String link, String description) {
    if (!StringUtils.hasText(issueId) || !StringUtils.hasText(link) || !StringUtils.hasText(description)) {
      throw new RuntimeException();
    }

    var issue = new Issue(issueId, description, link, "Open", LocalDateTime.now());

    try {
      issueRepository.createIssue(issue);
    } catch (Exception e) {}

    return issue;
  }

  @Override
  public Issue deleteIssue(final String issueId) {
    if (!StringUtils.hasText(issueId)) {
      throw new RuntimeException();
    }

    return issueRepository.deleteIssue(issueId);
  }
}
