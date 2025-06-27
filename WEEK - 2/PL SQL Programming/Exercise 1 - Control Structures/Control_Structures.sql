-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount to interest rates for customers above 60
BEGIN
  FOR rec IN (SELECT * FROM Customers c JOIN Loans l ON c.CustomerID = l.CustomerID) LOOP
    IF MONTHS_BETWEEN(SYSDATE, rec.DOB)/12 > 60 THEN
      UPDATE Loans SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;
    END IF;
  END LOOP;
END;
/

-- Scenario 2: Set IsVIP flag for balance > $10,000
ALTER TABLE Customers ADD IsVIP BOOLEAN;
BEGIN
  FOR rec IN (SELECT * FROM Customers) LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers SET IsVIP = TRUE WHERE CustomerID = rec.CustomerID;
    END IF;
  END LOOP;
END;
/

-- Scenario 3: Reminders for loans due in next 30 days
BEGIN
  FOR rec IN (SELECT * FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for Customer ' || rec.CustomerID || ' is due soon.');
  END LOOP;
END;
/