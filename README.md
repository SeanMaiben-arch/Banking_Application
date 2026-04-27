" Banking_Application" 

## Class Breakdown

### Account
Represents a single user’s account. It stores the name, balance, and any loan amount, and provides simple methods for depositing and withdrawing money.

### AccountTestClass
Tests the core behaviour of the Account class, including deposits, withdrawals, and handling of invalid inputs.

### BankService
Acts as the main hub for managing accounts. It keeps a collection of all accounts and handles things like adding new users and processing transactions.

### BankServiceTestClass
Verifies that account management and transactions work as expected, including edge cases like missing accounts or invalid operations.

### LoanService
Handles loan-related logic. It checks whether a loan can be given, updates account balances, and processes repayments.

### LoanServiceTestClass
Tests loan approval and repayment logic to ensure rules are enforced correctly and balances update as expected.

### Runner
A simple entry point used to run and test the system.

### RunnerTestSuite
Groups and runs all test classes together to ensure the overall system behaves correctly.

NOTES: 
This is an in-memory system, so everything resets each time the program runs. It’s designed for learning and demonstration rather than real-world use."
