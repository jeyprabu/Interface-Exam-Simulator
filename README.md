# Interface-Exam-Simulator
This is an exam simulator created using Java. This uses MySQL database. 
It allows you to simulate an examination. The admins can add questions for a scheduled test. The students can take up the test and they will be evaluated and marked by the end of the scheduled time.
DATABASE FIELDS:
These tables will be required for the same - 
Login Table   (USER_NAME varchar(20), USER_PASS varchar(20), STATUS char(1))
Chapter Table (LOOPS varchar(20), ARRAYS varchar(20), OPERATORS varchar(20), FUNDAMENTALS varchar(20))
Exam Table    (SL_NO int, FUNDAMENTAL_QUE varchar(4000), OPTIONS varchar(20), ANSWERs varchar(20))
Result Table  (USER_NAME varchar(20), USER_CHAPTER varchar(20), RESULT int, TOTAL_QUE int, TOTLA_MARKS int, TOTAL_QUE_ATT int, CORRECT_ATT int, PER_MARK_OBT int, TIME_TAK time)
