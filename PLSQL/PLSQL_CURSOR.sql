-- B�i t?p 1: X�y d?ng kh?i l?nh khi nh?p m� khoa th� s? hi?n th? nh?ng h?c sinh c?a khoa ?�.
DECLARE
  CURSOR STUDENT_CUR(p_stu_fac_id STUDENT.FACULTY_ID%TYPE)
  IS
    SELECT stu.FIRST_NAME,
      stu.LAST_NAME
    FROM STUDENT stu
    WHERE stu.FACULTY_ID      = p_stu_fac_id;
  id_faculty CHAR(4) := &id_faculty;
BEGIN
  FOR v_student IN STUDENT_CUR(id_faculty)
  LOOP
    Dbms_Output.Put_Line('-Hoc sinh: ' || v_student.LAST_NAME ||' '|| v_student.FIRST_NAME);
  END LOOP;
END;

--------------------------------------------------------------------------------
-- B�i t?p 2: X�y d?ng kh?i l?nh li?t k� nh?ng m�n h?c c?a t?ng h?c sinh theo h?c.
DECLARE
  CURSOR STUDENT_CUR
  IS
    SELECT ID, FIRST_NAME,LAST_NAME FROM STUDENT;
  CURSOR SUBJECT_CUR( p_student_id STUDENT.ID%TYPE)
  IS
    SELECT sub.Name
    FROM SUBJECTS sub
    INNER JOIN SCORE sc
    ON sc.SUBJECTS_ID   = sub.ID
    WHERE sc.STUDENT_ID = p_student_id;
  v_student STUDENT_CUR%Rowtype;
  v_subject SUBJECT_CUR%Rowtype;
BEGIN
  OPEN STUDENT_CUR;
  LOOP
    FETCH STUDENT_CUR INTO v_student;
    EXIT
  WHEN STUDENT_CUR%Notfound;
    Dbms_Output.Put_Line(STUDENT_CUR%rowcount || '-H? t�n ??y ??: ' || v_student.first_name || ' ' || v_student.last_name);
    Dbms_Output.Put_Line('M�n theo h?c:');
    OPEN SUBJECT_CUR(v_student.id);
    LOOP
      FETCH SUBJECT_CUR INTO v_subject;
      EXIT
    WHEN SUBJECT_CUR%Notfound;
      Dbms_Output.Put_Line(' ' || v_subject.name);
    END LOOP;
    CLOSE SUBJECT_CUR;
  END LOOP;
  CLOSE STUDENT_CUR;
END;

--------------------------------------------------------------------------------
-- B�i t?p 3: X�y d?ng kh?i l?nh th?c hi?n x�a th�ng tin nh?ng h?c sinh(Student, SCORE) thu?c khoa nh?p v�o
DECLARE
  CURSOR STUDENT_CUR(p_stu_fac_id STUDENT.FACULTY_ID%TYPE)
  IS
    SELECT stu.ID
    FROM STUDENT stu
    INNER JOIN FACULTY fac
    ON fac.ID         = stu.FACULTY_ID
    WHERE fac.ID      = p_stu_fac_id;
  id_faculty CHAR(4) := &id_faculty;
BEGIN
  FOR v_student IN STUDENT_CUR(id_faculty)
  LOOP
    DELETE FROM SCORE WHERE SCORE.STUDENT_ID =v_student.ID;
  END LOOP;
  DELETE FROM STUDENT WHERE FACULTY_ID = id_faculty;
END;

--------------------------------------------------------------------------------
--B�i t?p 4: X�y d?ng kh?i l?nh th?c hi?n c?p nh?t l?i ?i?m c?ng th�m 2 ?i?m cho nh?ng m�n h?c c� m� s? 2

DECLARE
  CURSOR SCORE_CUR(p_sub_id SCORE.SUBJECTS_ID%TYPE)
  IS
    SELECT scr.STUDENT_ID,
      scr.SUBJECTS_ID
    FROM SCORE scr
    WHERE scr.SUBJECTS_ID = p_sub_id;
  p_sub_id CHAR(4)       := &p_sub_id;
BEGIN
  FOR v_score IN SCORE_CUR(p_sub_id)
  LOOP
    UPDATE SCORE
    SET SCORE         = SCORE + 2
    WHERE SUBJECTS_ID = v_score.SUBJECTS_ID
    AND STUDENT_ID    = v_score.STUDENT_ID;
  END LOOP;
END;

  
