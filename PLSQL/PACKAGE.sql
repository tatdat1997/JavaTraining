--------------------------------------------------------------------------------
--Cau 1:
CREATE PACKAGE Pkg_Emp AS
 -- Hàm trả về First_Name
 Function FIND_NAMES(S_STUDENT_ID STUDENT.ID%Type)

    Return STUDENT.First_Name%Type;

End Pkg_Emp;

CREATE OR REPLACE PACKAGE BODY Pkg_Emp AS
  Function FIND_NAMES(S_STUDENT_ID STUDENT.ID%Type)
  Return STUDENT.First_Name%Type AS
  v_first_name STUDENT.First_Name%Type;
  v_last_name STUDENT.Last_Name%Type;
  v_full_name STUDENT.First_Name%Type;
  BEGIN
    SELECT FIRST_NAME, LAST_NAME INTO  v_first_name, v_last_name FROM STUDENT WHERE ID = S_STUDENT_ID;
    v_full_name := v_first_name ||' '||v_last_name;
    Dbms_Output.Put_Line('Student name = ' || v_full_name);
    RETURN v_full_name;
  END;
End Pkg_Emp;



--------------------------------------------------------------------------------
-- Cau 2

CREATE OR REPLACE PACKAGE Pkg_STUDENT AS
 -- Hàm tim hoc sinh
  FUNCTION FIND_NAMES(S_STUDENT_ID STUDENT.ID%Type)

    Return STUDENT.First_Name%Type;

-- Hàm in ten  
  FUNCTION PRINT_STUDENT_NAME(S_STUDENT_ID STUDENT.ID%Type)

  Return VARCHAR2;
  
End Pkg_STUDENT;

CREATE OR REPLACE PACKAGE BODY Pkg_STUDENT AS
  FUNCTION FIND_NAMES(S_STUDENT_ID STUDENT.ID%Type)
  Return STUDENT.First_Name%Type AS
  v_first_name STUDENT.First_Name%Type;
  v_last_name STUDENT.Last_Name%Type;
  v_full_name STUDENT.First_Name%Type;
  BEGIN
    SELECT FIRST_NAME, LAST_NAME INTO  v_first_name, v_last_name FROM STUDENT WHERE ID = S_STUDENT_ID;
    v_full_name :=  v_last_name||' '||v_first_name;
    RETURN v_full_name;
    EXCEPTION
    WHEN No_Data_Found THEN
      -- Ghi ra màn hình Console.
      Dbms_Output.Put_Line('Student not found');
     RETURN null;
  END;
  
  FUNCTION PRINT_STUDENT_NAME(S_STUDENT_ID STUDENT.ID%Type)
  Return VARCHAR2 AS
  S_NAME VARCHAR2(250);
  BEGIN
    S_NAME := FIND_NAMES(S_STUDENT_ID);
    Dbms_Output.Put_Line('Student name: ' ||S_NAME);
    RETURN S_NAME;
  END;
  
  
End Pkg_STUDENT;
--------------------------------------------------------------------------------
--Bài tập 3 - 4: Tạo package có  hàm print_student_name và print_max_score in ra 
--điểm cao nhất của tất cả môn học mà các sinh viên theo học
--điểm nhỏ nhất của tất cả môn học mà các sinh viên theo học

CREATE OR REPLACE PACKAGE Pkg_SCORE AS
-- Hàm in ten  
  FUNCTION PRINT_STUDENT_NAME

  Return VARCHAR2;
  
  FUNCTION PRINT_MAX_SCORE
  
  RETURN VARCHAR2;
  
  FUNCTION PRINT_MIN_SCORE
  
  RETURN VARCHAR2;
End Pkg_SCORE;

CREATE OR REPLACE PACKAGE BODY Pkg_SCORE AS

  FUNCTION PRINT_STUDENT_NAME
    Return VARCHAR2 AS
    BEGIN
      RETURN 'name';
  END;
  
  FUNCTION PRINT_MAX_SCORE
    Return VARCHAR2 AS
    V_SCORE FLOAT;
    BEGIN
    SELECT MAX(SCORE) INTO V_SCORE FROM SCORE;
          Dbms_Output.Put_Line('MAX score is : ' ||V_SCORE); 
    END;
  FUNCTION PRINT_MIN_SCORE
    Return VARCHAR2 AS
    V_SCORE FLOAT;
    BEGIN
    SELECT MIN(SCORE) INTO V_SCORE FROM SCORE;
          Dbms_Output.Put_Line('MIN score is : ' ||V_SCORE); 
    END;  
End Pkg_SCORE;

------------------------------------------------
DECLARE 
result VARCHAR2(250);
results VARCHAR2(250);
BEGIN 
--   result := PKG_SCORE.PRINT_MIN_SCORE; 
   results := PKG_SCORE.PRINT_MAX_SCORE;
END; 
--------------------------------


CREATE OR REPLACE PACKAGE Pkg_FACULTY AS
  FUNCTION COUNT_STUDENT_BY_FACULTY(S_FACULTY_ID STUDENT.FACULTY_ID%Type)
  
  RETURN NUMBER;
End Pkg_FACULTY;

CREATE OR REPLACE PACKAGE BODY Pkg_FACULTY AS
  FUNCTION COUNT_STUDENT_BY_FACULTY(S_FACULTY_ID STUDENT.FACULTY_ID%Type)
  RETURN NUMBER AS
  V_TOTAL NUMBER;
    BEGIN
      SELECT COUNT(*) INTO V_TOTAL FROM STUDENT WHERE FACULTY_ID = S_FACULTY_ID;
      RETURN V_TOTAL; 
    END;  
End Pkg_FACULTY;
