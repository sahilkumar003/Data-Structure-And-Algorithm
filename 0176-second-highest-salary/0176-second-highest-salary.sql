# Write your MySQL query statement below

SELECT max(salary) as SecondHighestSalary from Employee where salary not in (select max(salary) from employee);
