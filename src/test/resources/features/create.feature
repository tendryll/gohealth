Feature: As a user, I want to create an issue

  Background:
    Given an issue id = "1"
    Given a link = "http://gohealth.com/issue/1"
    Given a description = "a description"
    Given an action = "create"

  Scenario: An issue is successfully created