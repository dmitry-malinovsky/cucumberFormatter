Feature: Sending email

  @UI @Send_Email
  Scenario: Email sent successfully
    Given user logs in "Gmail"
    And user creates new message
    When user sends valid message to "xxx.gmail.com"
    Then email is successfully recieved
