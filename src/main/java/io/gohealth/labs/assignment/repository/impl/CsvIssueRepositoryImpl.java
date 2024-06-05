package io.gohealth.labs.assignment.repository.impl;

import io.gohealth.labs.assignment.model.Issue;
import io.gohealth.labs.assignment.repository.IssueRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Repository
public class CsvIssueRepositoryImpl implements IssueRepository {
  @Override
  public Issue createIssue(Issue issue) {
    String createdAt = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(issue.getCreatedAt());
    String line = String.format("%s|%s||%s|%s|%s", issue.getIssueId(), issue.getDescription(), issue.getStatus(),
        createdAt, issue.getLink());

    File file = new File("./issues.csv");
    boolean fileExists = file.exists();

    try (FileWriter writer = new FileWriter("./issues.csv", true);
         BufferedWriter bwr = new BufferedWriter(writer)) {
      createHeader(bwr, fileExists);
      bwr.write(line);
      bwr.newLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return issue;
  }

  private static void createHeader(BufferedWriter bwr, boolean fileExists) throws IOException {
    if (!fileExists) {
      bwr.write("id|description|parent id|status|CreationTimestamp|link");
      bwr.newLine();
    }
  }

  @Override
  public Issue deleteIssue(String issueId) {
    Issue issue = null;
    var issues = new ArrayList<String>();

    try (FileReader reader = new FileReader("./issues.csv");
         BufferedReader br = new BufferedReader(reader)) {
      br.readLine(); // ignore the header

      String line;
      while((line = br.readLine()) != null) {
        var iss = line.split("\\|");
        var id = iss[0];
        var link = iss[5];
        var description = iss[1];
        var status = iss[3];
        var ldt = LocalDateTime.parse(iss[4], DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        if (issueId.equals(id)) {
          issue = new Issue(issueId, link, description, "Closed", LocalDateTime.now());
        } else {
          issue = new Issue(id, link, description, status, LocalDateTime.now());
        }

        String issueRecord = String.format("%s|%s||%s|%s|%s", issue.getIssueId(), issue.getDescription(),
            issue.getStatus(), ldt, issue.getLink());
        issues.add(issueRecord);
      }
    } catch (IOException e) {
      // throw new RuntimeException(e);
    }

    try (FileWriter writer = new FileWriter("./issues.csv", false);
         BufferedWriter bwr = new BufferedWriter(writer)) {
      createHeader(bwr, false);

      for (String line: issues) {
        bwr.write(line);
        bwr.newLine();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return issue;
  }
}
