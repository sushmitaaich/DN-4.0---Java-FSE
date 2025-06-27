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
