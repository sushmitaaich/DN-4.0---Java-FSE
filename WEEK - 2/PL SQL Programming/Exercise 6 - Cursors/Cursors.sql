-- Exercise 6: Cursors

-- Scenario 1: Monthly statements
DECLARE
  CURSOR cur IS SELECT * FROM Transactions WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE);
BEGIN
  FOR rec IN cur LOOP
    DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || rec.TransactionID || ', Account: ' || rec.AccountID || ', Amount: ' || rec.Amount);
  END LOOP;
END;
/

-- Scenario 2: Apply annual fee
DECLARE
  CURSOR cur IS SELECT * FROM Accounts;
BEGIN
  FOR rec IN cur LOOP
    UPDATE Accounts SET Balance = Balance - 100 WHERE AccountID = rec.AccountID;
  END LOOP;
END;
/

-- Scenario 3: Update loan interest
DECLARE
  CURSOR cur IS SELECT * FROM Loans;
BEGIN
  FOR rec IN cur LOOP
    UPDATE Loans SET InterestRate = InterestRate + 0.5 WHERE LoanID = rec.LoanID;
  END LOOP;
END;
/
