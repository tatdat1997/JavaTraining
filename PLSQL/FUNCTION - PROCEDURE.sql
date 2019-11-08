-- Bài tập 1: Xây dựng hàm tính n giai thừa?
CREATE OR REPLACE FUNCTION GIAI_THUA(n IN NUMBER )
  RETURN NUMBER
IS
  x NUMBER;
BEGIN
  IF n=0 THEN
    x   := 1;
  ELSE
    x := n * GIAI_THUA(n-1);
  END IF;
RETURN x;
END GIAI_THUA;
---------------------
DECLARE
  result NUMBER;
  x NUMBER;
BEGIN
  x := &x;
  result := GIAI_THUA(x);
  DBMS_OUTPUT.put_line('Result: ' || result);
END;
--------------------------------------------------------------------------------

--Bài tập 2: Thủ tục find_sname

CREATE OR REPLACE PROCEDURE find_sname(
    i_student_id IN STUDENT.ID%TYPE,
    o_first_name OUT STUDENT.FIRST_NAME%TYPE,
    o_last_name OUT STUDENT.LAST_NAME%TYPE)
AS
BEGIN
  SELECT FIRST_NAME,
    LAST_NAME
  INTO o_first_name,
    o_last_name
  FROM STUDENT
  WHERE ID = i_student_id;
EXCEPTION
WHEN No_Data_Found THEN
  -- Ghi ra màn hình Console.
  Dbms_Output.Put_Line('No Record found with student id = ' || i_student_id);
END FIND_SNAME;
--------------------------------------
DECLARE
  v_first_name STUDENT.FIRST_NAME%TYPE;
  v_last_name STUDENT.LAST_NAME%TYPE;
  v_student_id STUDENT.ID%TYPE;
BEGIN
  v_student_id := &v_student_id;
  FIND_SNAME(v_student_id, v_first_name, v_last_name);
  Dbms_Output.Put_Line('Student found:' || v_first_name || ' ' ||v_last_name);
END;

--------------------------------------------------------------------------------
--Bài tập 3: Thủ tục  print_student_name
CREATE OR REPLACE PROCEDURE print_student_name(
    i_student_id IN STUDENT.ID%TYPE,
    V_RESULT OUT VARCHAR2
    )
AS
V_FIRST_NAME STUDENT.FIRST_NAME%TYPE;
V_LAST_NAME STUDENT.LAST_NAME%TYPE;
BEGIN
  SELECT LAST_NAME, FIRST_NAME
  INTO V_LAST_NAME, V_FIRST_NAME
  FROM STUDENT
  WHERE ID = i_student_id;
  V_RESULT :=  V_LAST_NAME ||' '|| V_FIRST_NAME;
  Dbms_Output.Put_Line('Student id '|| i_student_id ||' name = ' || V_RESULT);
EXCEPTION
WHEN No_Data_Found THEN
  -- Ghi ra màn hình Console.
  Dbms_Output.Put_Line('No Record found with student id = ' || i_student_id);
END print_student_name;
-------------------------
DECLARE
  v_student_id STUDENT.ID%TYPE;
  v_name STUDENT.FIRST_NAME%TYPE;
BEGIN
  v_student_id := &v_student_id;
  print_student_name(v_student_id, v_name);
END;

--------------------------------------------------------------------------------
--Bài tập 4: Viết thủ tục tên update_score
CREATE OR REPLACE PROCEDURE PLUS_SCORE(
    I_ADDRESS IN STUDENT.ADDRESS%TYPE,
    I_SEX IN STUDENT.SEX%TYPE,
    I_FACULTY_NAME IN FACULTY.ID%TYPE
    )
AS
BEGIN
  UPDATE SCORE 
  SET SCORE.SCORE = SCORE.SCORE+1
  WHERE STUDENT_ID = (
    SELECT stu.ID 
    FROM STUDENT stu
    WHERE stu.ADDRESS = I_ADDRESS
      AND stu.FACULTY_ID = I_FACULTY_NAME
      AND stu.SEX = I_SEX
  );
  Dbms_Output.Put_Line('Update success');
  EXCEPTION
  WHEN No_Data_Found THEN
  -- Ghi ra màn hình Console.
  Dbms_Output.Put_Line('No Record found with student');
END;
------------------------------
DECLARE
I_FACULTY_NAME FACULTY.ID%TYPE;
I_ADDRESS STUDENT.ADDRESS%TYPE; 
I_SEX STUDENT.SEX%TYPE;
BEGIN
I_ADDRESS := '&I_ADDRESS';
I_SEX := '&I_SEX';
I_FACULTY_NAME  := &I_FACULTY_NAME;
  PLUS_SCORE(I_ADDRESS,I_SEX,I_FACULTY_NAME);
END;










