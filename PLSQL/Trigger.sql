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
BEFORE INSERT ON STUDENT
FOR EACH ROW 
DECLARE
  counter number;
BEGIN
  counter := 0;
  SELECT COUNT(*) 
  INTO counter 
  FROM STUDENT ST
  WHERE ST.FACULTY_ID = :NEW.FACULTY_ID;
  UPDATE FACULTY
    SET QUALITY = counter+1
    WHERE ID = :NEW.FACULTY_ID;
  Dbms_Output.Put_Line('Insert student success ');
END;
--------------------------------------------------------------------------------
--Bai 4: Trigger hien thi diem vaf diem trung binh

CREATE OR REPLACE TRIGGER TRIG_AFTER_INST_SCORE
BEFORE INSERT OR UPDATE ON SCORE
FOR EACH ROW 
DECLARE
  average FLOAT;
  total FLOAT;
BEGIN
  average := 0;
  SELECT SUM(Sc.SCORE), COUNT(Sc.SCORE) 
  INTO average, total
  FROM SCORE Sc
  WHERE Sc.STUDENT_ID = :NEW.STUDENT_ID;

    average := average + :NEW.SCORE;
    total := total + 1;
    average := average / total;
    Dbms_Output.Put_Line('Student has an average is  '||average);

END;

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
  if max_subject > 3 then
    raise_application_error(-20000, 'Student can not study more than 3 subject!'); 
  end if;
END;




