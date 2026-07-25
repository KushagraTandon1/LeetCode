# Write your MySQL query statement below
SELECT 
Employee_id,
CASE 
WHEN Employee_id % 2 = 1 AND name NOT LIKE 'M%' THEN SALARY
ELSE 0
END AS Bonus
FROM Employees
Order by Employee_id;