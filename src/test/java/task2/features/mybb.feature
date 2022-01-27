@web
Feature: test for mybb forum

  Scenario: read thread by guest
  Given I press on 'my forum'
  And I press on 'test1 thread'
  Then I can see on page 'my first test message'

  Scenario: create new thread by user3
  Given I Login by "user3" with pwd "aq1aq1"
  And I press on 'my forum'
  And I press button 'post thread'
  And I type "New auto subject" in "thread subject"
  And I type "New auto message" in "your message"
  And I press button 'post thread submit'
