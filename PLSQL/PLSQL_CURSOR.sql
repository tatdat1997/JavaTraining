-- Bài t?p 1: Xây d?ng kh?i l?nh khi nh?p mã khoa thì s? hi?n th? nh?ng h?c sinh c?a khoa ?ó.
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
-- Bài t?p 2: Xây d?ng kh?i l?nh li?t kê nh?ng môn h?c c?a t?ng h?c sinh theo h?c.
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
  -- Khai báo m?t ki?u ROWTYPE d?a trên Cursor v?a t?o.
  v_student STUDENT_CUR%Rowtype;
  v_subject SUBJECT_CUR%Rowtype;
BEGIN
  -- M? Cursor (Truy?n các giá tr? tham s? vào).
  OPEN STUDENT_CUR;
  LOOP
    FETCH STUDENT_CUR INTO v_student;
    EXIT
  WHEN STUDENT_CUR%Notfound;
    Dbms_Output.Put_Line(STUDENT_CUR%rowcount || '-H? tên ??y ??: ' || v_student.first_name || ' ' || v_student.last_name);
    Dbms_Output.Put_Line('Môn theo h?c:');
    -- M? Cursor (Truy?n các giá tr? tham s? vào).
    OPEN SUBJECT_CUR(v_student.id);
    LOOP
      FETCH SUBJECT_CUR INTO v_subject;
      EXIT
    WHEN SUBJECT_CUR%Notfound;
      Dbms_Output.Put_Line(' ' || v_subject.name);
    END LOOP;
    -- ?óng Cursor.
    CLOSE SUBJECT_CUR;
  END LOOP;
  -- ?óng Cursor.
  CLOSE STUDENT_CUR;
END;
-- Bài t?p 3: Xây d?ng kh?i l?nh th?c hi?n xóa thông tin nh?ng h?c sinh(Student, SCORE) thu?c khoa nh?p vào
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
--Bài t?p 4: Xây d?ng kh?i l?nh th?c hi?n c?p nh?t l?i ?i?m c?ng thêm 2 ?i?m cho nh?ng môn h?c có mã s? 2
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

  
