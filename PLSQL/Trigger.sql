--Bai tap 1: Rang buoc khi them
CREATE OR REPLACE TRIGGER TRIG_AFTER_INST_STUDENT 
AFTER INSERT ON STUDENT
FOR EACH ROW 
BEGIN
  Dbms_Output.Put_Line('Insert student success');
END;
--------------------------------------------------------------------------------
--Bai tap 2: Rang buoc khi xoa 1 hoc sinh

CREATE OR REPLACE TRIGGER TRIG_AFTER_DELETE_STUDENT
BEFORE DELETE ON STUDENT 
FOR EACH ROW
BEGIN
  DELETE FROM SCORE SC WHERE SC.STUDENT_ID = :OLD.ID;
END;

--------------------------------------------------------------------------------
--Bai tap 3

CREATE OR REPLACE TRIGGER TRIG_AFTER_INST_STUDENT_UPDATE_FACULTY
FOR INSERT ON STUDENT
COMPOUND TRIGGER
  v_faculty_id STUDENT.FACULTY_ID%TYPE;
  counter NUMBER :=0;
AFTER EACH ROW IS
  BEGIN
    v_faculty_id := :NEW.FACULTY_ID;
END AFTER EACH ROW;
AFTER STATEMENT IS
  BEGIN
    SELECT COUNT(*) 
    INTO counter 
    FROM STUDENT 
    WHERE FACULTY_ID = v_faculty_id;
    UPDATE FACULTY
      SET QUALITY = counter
      WHERE ID = v_faculty_id;  
END AFTER STATEMENT;
END TRIG_AFTER_INST_STUDENT_UPDATE_FACULTY;

--------------------------------------------------------------------------------

CREATE OR REPLACE TRIGGER TRIG_AFTER_INST_SCORE
FOR INSERT OR UPDATE ON SCORE
COMPOUND TRIGGER
  v_student_id SCORE.STUDENT_ID%TYPE;
  v_subject_id SCORE.SUBJECTS_ID%TYPE;
  total_score NUMBER :=0;
  total_credit NUMBER :=0;
AFTER EACH ROW IS
  BEGIN
    v_student_id := :NEW.STUDENT_ID;
END AFTER EACH ROW;
AFTER STATEMENT IS
  BEGIN
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
    av FLOAT;
  BEGIN
  FOR v_score IN AV_SCORE_CUR(v_student_id)
    LOOP
    FOR av_score IN AV_SUBJECTS(v_score.SUBJECTS_ID)
    LOOP
      total_score := total_score + av_score.credit * v_score.sco;
      total_credit := total_credit + av_score.credit;
    END LOOP;
  END LOOP;
  Dbms_Output.Put_Line('Tong diem: ' ||total_score);
  Dbms_Output.Put_Line('Tong tin chi: ' ||total_credit);
  av := total_score/total_credit;
  Dbms_Output.Put_Line('Trung binh mon hoc: ' ||av);
  END;
END AFTER STATEMENT;
END TRIG_AFTER_INST_SCORE;

CREATE OR REPLACE TRIGGER TRIG_AFTER_DELETE_SCORE
FOR DELETE ON SCORE
COMPOUND TRIGGER
  v_student_id SCORE.STUDENT_ID%TYPE;
  v_subject_id SCORE.SUBJECTS_ID%TYPE;
  total_score NUMBER :=0;
  total_credit NUMBER :=0;
AFTER EACH ROW IS
  BEGIN
    v_student_id := :OLD.STUDENT_ID;
END AFTER EACH ROW;
AFTER STATEMENT IS
  BEGIN
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
    av FLOAT;
  BEGIN
  FOR v_score IN AV_SCORE_CUR(v_student_id)
    LOOP
    FOR av_score IN AV_SUBJECTS(v_score.SUBJECTS_ID)
    LOOP
      total_score := total_score + av_score.credit * v_score.sco;
      total_credit := total_credit + av_score.credit;
    END LOOP;
  END LOOP;
  Dbms_Output.Put_Line('Tong diem: ' ||total_score);
  Dbms_Output.Put_Line('Tong tin chi: ' ||total_credit);
  av := total_score/total_credit;
  Dbms_Output.Put_Line('Trung binh mon hoc: ' ||av);
  END;
END AFTER STATEMENT;
END TRIG_AFTER_DELETE_SCORE;
--------------------------------------------------------------------------------
--Bai 5: Trigger khong duoc hoc qua 3 mon

CREATE OR REPLACE TRIGGER TRIG_BEFORE_INST_SCORE
BEFORE INSERT ON SCORE
FOR EACH ROW 
DECLARE
  max_subject number;
BEGIN
  max_subject := 0;
  SELECT COUNT(*) 
  INTO max_subject 
  FROM SCORE Sc
  WHERE Sc.STUDENT_ID = :NEW.STUDENT_ID;
  if max_subject >= 3 then
    raise_application_error(-20000, 'Student can not study more than 3 subject!'); 
  end if;
END;

--------------------------------------------------------------------------------
--------------------------------------------------------------------------------