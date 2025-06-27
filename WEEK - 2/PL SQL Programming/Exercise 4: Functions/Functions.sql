-- Exercise 4: Functions

-- Scenario 1: Calculate age
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
BEGIN
  RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END;
/

-- Scenario 2: Monthly installment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_amount NUMBER, p_rate NUMBER, p_years NUMBER) RETURN NUMBER IS
  v_months NUMBER := p_years * 12;
  v_monthlyRate NUMBER := p_rate / (12 * 100);
BEGIN
  RETURN (p_amount * v_monthlyRate) / (1 - POWER(1 + v_monthlyRate, -v_months));
END;
/

-- Scenario 3: Check balance
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_accId NUMBER, p_amt NUMBER) RETURN BOOLEAN IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_accId;
  RETURN v_balance >= p_amt;
END;
/

