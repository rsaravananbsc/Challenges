#Author: srajamanickam@aubay.com

Feature: Verification of Email Test

  Scenario: Verification of Email Test on Message Server

    Given A User sends an "Hello" message
    When The message is converted by the Adapter - Adapater 
    Then The Message server should contain the "Hello" message in the queue - Event, APP
