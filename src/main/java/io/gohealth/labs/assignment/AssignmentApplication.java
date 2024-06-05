package io.gohealth.labs.assignment;

import io.gohealth.labs.assignment.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication implements ApplicationRunner {
	private static final Logger LOG = LoggerFactory.getLogger(AssignmentApplication.class);

	@Value("${issue.id}")
	private String issueId;

	@Value("${description}")
	private String description;

	@Value("${link}")
	private String link;

	@Value("${action}")
	private String action;

	@Autowired
	private IssueService issueService;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) {
		if (action.equalsIgnoreCase("create")) {
			issueService.createIssue(issueId, description, link);
		} else if (action.equalsIgnoreCase("close")) {
			issueService.deleteIssue(issueId);
		}
	}

	public void setIssueId(final String issueId) {
		this.issueId = issueId;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public void setAction(final String action) {
		this.action = action;
	}

	public void setIssueService(final IssueService issueService) {
		this.issueService = issueService;
	}
}
