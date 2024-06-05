package io.gohealth.labs.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(
		properties = {
				"issue.id=1",
				"description=my description",
				"link=http://blog.com",
				"action=create"
		}
)
class AssignmentApplicationTests {
	@Test
	void t1() {
		try (FileReader reader = new FileReader("./issues.csv");
				 BufferedReader br = new BufferedReader(reader)) {
			String header = br.readLine();
			String[] issue = br.readLine().split("\\|");

			assertEquals("id|description|parent id|status|CreationTimestamp|link", header);
			assertEquals("1", issue[0]);
			assertEquals("my description", issue[1]);
			assertEquals("Open", issue[3]);
			assertEquals("http://blog.com", issue[5]);

		} catch (IOException e) {
			// throw new RuntimeException(e);
		}
	}
}
