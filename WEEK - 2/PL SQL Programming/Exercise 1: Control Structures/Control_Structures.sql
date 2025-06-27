-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount to interest rates for Customers1 above 60

BEGIN
  FOR rec IN (SELECT * FROM Customers1 c JOIN Loans l ON c.CustomerID = l.CustomerID) LOOP
    IF MONTHS_BETWEEN(SYSDATE, rec.DOB)/12 > 60 THEN
      UPDATE Loans SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;
    END IF;
  END LOOP;
END;
/

-- Scenario 2: Update salary with error handling
CREATE OR REPLACE PROCEDURE UpdateSalary(p_empId NUMBER, p_percent NUMBER) IS
BEGIN
  UPDATE Employees SET Salary = Salary + (Salary * p_percent / 100)
  WHERE EmployeeID = p_empId;
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Employee not found');
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Scenario 3: Add new customer safely
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
BEGIN
  INSERT INTO Customers1(CustomerID, Name, DOB, Balance, LastModified) 
  VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Customer already exists.');
END;
/
