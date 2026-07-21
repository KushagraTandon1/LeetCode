SELECT U.name as name, SUM(T.amount) as balance
FROM Users U Inner Join Transactions T
ON U.account = T.account
GROUP BY U.account 
HAVING balance > 10000;