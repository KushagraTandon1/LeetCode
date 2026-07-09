Select U.name as name, CASE
WHEN SUM(R.distance) is not null THEN SUM(R.distance)
ELSE 0 
END AS  travelled_distance
FROM Users U Left Join Rides R On
U.id = R.user_id
Group By U.id
Order By travelled_distance DESC, name ASC;