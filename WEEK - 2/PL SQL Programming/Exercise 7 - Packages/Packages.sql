-- Exercise 7: Packages

-- Scenario 1: CustomerManagement package
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    INSERT INTO Customers(CustomerID, Name, LastModified) VALUES(p_id, p_name, SYSDATE);
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Customers SET Name = p_name, LastModified = SYSDATE WHERE CustomerID = p_id;
  END;

  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
    v_bal NUMBER;
  BEGIN
    SELECT Balance INTO v_bal FROM Customers WHERE CustomerID = p_id;
    RETURN v_bal;
  END;
END;
/

-- Scenario 2: EmployeeManagement package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
  FUNCTION AnnualSalary(p_id NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    INSERT INTO Employees(EmployeeID, Name, HireDate) VALUES(p_id, p_name, SYSDATE);
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees SET Salary = p_salary WHERE EmployeeID = p_id;
  END;

  FUNCTION AnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_sal NUMBER;
  BEGIN
    SELECT Salary INTO v_sal FROM Employees WHERE EmployeeID = p_id;
    RETURN v_sal * 12;
  END;
END;
/

-- Scenario 3: AccountOperations package
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_custId NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION TotalBalance(p_custId NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_custId NUMBER) IS
  BEGIN
    INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES(p_id, p_custId, 'Savings', 0, SYSDATE);
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;
  END;

  FUNCTION TotalBalance(p_custId NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_custId;
    RETURN v_total;
  END;
END;
/

