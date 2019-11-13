-- B�i t?p 1: X�y d?ng kh?i l?nh khi nh?p m� khoa th� s? hi?n th? nh?ng h?c sinh c?a khoa ?�.
DECLARE
  CURSOR FACULTY_CUR(p_faculty_id FACULTY.ID%TYPE)
  IS
    SELECT fac.NAME FROM FACULTY fac WHERE fac.ID = p_faculty_id;
  CURSOR STUDENT_CUR(p_stu_fac_id STUDENT.FACULTY_ID%TYPE)
  IS
    SELECT stu.FIRST_NAME,
      stu.LAST_NAME
    FROM STUDENT stu
    INNER JOIN FACULTY fac
    ON fac.ID         = stu.FACULTY_ID
    WHERE fac.ID      = p_stu_fac_id;
  id_faculty CHAR(4) := &id_faculty;
BEGIN
  FOR v_faculty IN FACULTY_CUR(id_faculty)
  LOOP
    Dbms_Output.Put_Line('-Khoa: ' || v_faculty.name );
    FOR v_student IN STUDENT_CUR(id_faculty)
    LOOP
      Dbms_Output.Put_Line('-Hoc sinh: ' || v_student.LAST_NAME ||' '|| v_student.FIRST_NAME);
    END LOOP;
  END LOOP;
END;
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
  -- Khai b�o m?t ki?u ROWTYPE d?a tr�n Cursor v?a t?o.
  v_student STUDENT_CUR%Rowtype;
  v_subject SUBJECT_CUR%Rowtype;
BEGIN
  -- M? Cursor (Truy?n c�c gi� tr? tham s? v�o).
  OPEN STUDENT_CUR;
  LOOP
    FETCH STUDENT_CUR INTO v_student;
    EXIT
  WHEN STUDENT_CUR%Notfound;
    Dbms_Output.Put_Line(STUDENT_CUR%rowcount || '-H? t�n ??y ??: ' || v_student.first_name || ' ' || v_student.last_name);
    Dbms_Output.Put_Line('M�n theo h?c:');
    -- M? Cursor (Truy?n c�c gi� tr? tham s? v�o).
    OPEN SUBJECT_CUR(v_student.id);
    LOOP
      FETCH SUBJECT_CUR INTO v_subject;
      EXIT
    WHEN SUBJECT_CUR%Notfound;
      Dbms_Output.Put_Line(' ' || v_subject.name);
    END LOOP;
    -- ?�ng Cursor.
    CLOSE SUBJECT_CUR;
  END LOOP;
  -- ?�ng Cursor.
  CLOSE STUDENT_CUR;
END;
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

  
--  
DECLARE
  CURSOR AV_SCORE_CUR(v_student_id STUDENT.ID%TYPE)
    IS
    SELECT sc.SCORE sco, sc.SUBJECTS_ID, sc.STUDENT_ID
    FROM SCORE sc
    WHERE sc.STUDENT_ID = v_student_id;
  CURSOR AV_SUBJECTS(subjects_id SUBJECTS.ID%TYPE)
    IS
    SELECT sub.CREDIT_NUM credit
    FROM SUBJECTS sub
    WHERE sub.ID = subjects_id;
  v_score AV_SCORE_CUR%Rowtype;
  av_score AV_SUBJECTS%Rowtype;
  total_score NUMBER;
  total_credit NUMBER;
  av FLOAT;
BEGIN
  total_score := 0; 
  total_credit := 0; 
  av := 0;
  FOR v_score IN AV_SCORE_CUR(4)
  LOOP
    FOR av_score IN AV_SUBJECTS(v_score.SUBJECTS_ID)
    LOOP
      total_score := total_score + av_score.credit * v_score.sco;
      total_credit := total_credit + av_score.credit;
      Dbms_Output.Put_Line('Mon hoc: ' ||v_score.SUBJECTS_ID);
      Dbms_Output.Put_Line('Tin chi: ' ||av_score.credit);
      Dbms_Output.Put_Line('Diem so: ' ||v_score.sco);
    END LOOP;
  END LOOP;
  av := total_score/total_credit;
  Dbms_Output.Put_Line('Trung binh mon hoc: ' ||av);
END;
