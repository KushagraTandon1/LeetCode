WITH Borrower AS (
    SELECT Book_Id, COUNT(Record_Id) AS Current_Borrower
    FROM Borrowing_Records
    WHERE Return_Date IS NULL
    GROUP BY Book_Id
)
SELECT
    L.Book_Id AS book_id,
    L.Title AS title,
    L.Author AS author,
    L.Genre AS genre,
    L.Publication_Year AS publication_year,
    B.Current_Borrower AS current_borrowers
FROM library_books L
INNER JOIN Borrower B
ON L.book_Id = B.book_Id
WHERE L.Total_Copies = B.current_borrower
ORDER BY
    B.Current_Borrower DESC,
    L.Title ASC;