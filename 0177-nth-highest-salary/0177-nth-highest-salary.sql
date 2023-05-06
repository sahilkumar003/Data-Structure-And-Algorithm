CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
# DECLARE M INT;
# SET M=N-1;
  RETURN (
      #  SELECT DISTINCT salary FROM Employee
      # ORDER BY salary DESC
      # LIMIT M,1
      
      select distinct e1.salary from Employee as e1 where N = 
      (select count(distinct e2.salary) from Employee as e2 where e2.salary>=e1.salary)
      
  );
END