@AllModules
Feature: DashBoard functionality
  Agile Story: As a sales manager, I should be able to access the different modules.

  Scenario: Dashboard options for sales managers
    Given sales manager is on the login page
    When user enter the login information
    Then sales manager should see the following modules
    |Discuss        |
    |Calendar       |
    |Notes          |
    |Contacts       |
    |CRM            |
    |Sales          |
    |Website        |
    |Point of Sale  |
    |Purchases      |
    |Inventory      |
    |Repairs        |
    |Invoicing      |
    |Email Marketing|
    |Events         |
    |Employees      |
    |Leaves         |
    |Expenses       |
    |Maintenance    |
    |Dashboards     |

