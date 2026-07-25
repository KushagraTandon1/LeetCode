# Write your MySQL query statement below
Select Event_day as day,
Emp_id,
Sum(Out_time - In_time) as total_time
FROM Employees
GROUP BY Emp_id, Event_day;