--------------------------------------------------------------------------------
-- Bai 1: EXCEPTION chia cho 0
DECLARE
  a NUMBER := &a;
  b NUMBER := &b;
  ex_error EXCEPTION;
BEGIN 
   IF b = 0 THEN 
      RAISE ex_error; 
   ELSE
      DBMS_OUTPUT.PUT_LINE (a||' / '||b||'= '|| a / b);
   END IF;
EXCEPTION 
   WHEN ex_error THEN 
      dbms_output.put_line('Error! Can not DIVIDE 0');  
END; 
--------------------------------------------------------------------------------
-- Bai 2: Tạo exception ném ra lỗi khi giá trị nhập vào vượt ngoài giới hạn chặn trước

DECLARE
  a NUMBER := &a;
  ex_error EXCEPTION;
BEGIN 
   IF (a < 0) OR (a > 100) THEN 
      RAISE ex_error;
   ELSE
      DBMS_OUTPUT.PUT_LINE (a);
   END IF;
EXCEPTION 
   WHEN ex_error THEN 
      dbms_output.put_line('Number must be 0 - 100');  
END; 

--------------------------------------------------------------------------------
--Bài tập 3: Tạo exception ném ra lỗi khi danh sách số học sinh lớn hơn 10

DECLARE
  V_NUMBER NUMBER := 0;
  ex_error EXCEPTION;
BEGIN 
   SELECT COUNT(*) INTO V_NUMBER FROM STUDENT;
   IF V_NUMBER > 10 THEN 
      RAISE ex_error;
   ELSE
    DBMS_OUTPUT.PUT_LINE('TỔNG SỐ HỌC SINH THEO HỌC LÀ: ');
    DBMS_OUTPUT.PUT_LINE (V_NUMBER);
   END IF;
EXCEPTION 
   WHEN ex_error THEN 
      dbms_output.put_line('Student can not more than 10!');  
END; 

--------------------------------------------------------------------------------
-- Bài tập 4: Tạo exception ném ra lỗi khi xuất hiện điểm nhỏ nhất nhỏ hơn 5

DECLARE
  CURSOR SCORE_CUR
  IS
    SELECT MIN(SCORE) MIN_SCORE FROM SCORE;
  ex_error EXCEPTION;
BEGIN 
  FOR v_score IN SCORE_CUR
    LOOP
      IF v_score.MIN_SCORE < 5 THEN 
        RAISE ex_error;
      ELSE
        DBMS_OUTPUT.PUT_LINE (v_score.MIN_SCORE);
      END IF;
    END LOOP;
  EXCEPTION 
    WHEN ex_error THEN
      DBMS_OUTPUT.PUT_LINE ('Min score less than 5!');
END; 

--------------------------------------------------------------------------------
--  Bai 5: Cho biết tam giác có hợp lệ không? Nếu có cho biết loại tam giác?

DECLARE
  A FLOAT := &A;
  B FLOAT := &B;
  C FLOAT := &C;
  ex_error EXCEPTION;
BEGIN
  IF ((A + B > C) and (A + C > B) and (B + C > A)) THEN 
    IF ((A = B) and (A = C)) THEN
        dbms_output.put_line('Day la tam giac deu.');
    ELSIF ((A = B) OR (A = C) OR (B = C)) THEN
      dbms_output.put_line('Day la tam giac can.');
    ELSIF ((A**2 + B**2 = C**2) OR (A**2 + C**2 = B**2) OR (C**2 + B**2 = A**2)) THEN
        IF ((A = B) OR (A = C) OR (B = C)) THEN
           dbms_output.put_line('Day la tam giac vuong can.');
        ELSE
          dbms_output.put_line('Day la tam giac vuong.');
        END IF;
    END IF;    
  ELSE
    RAISE ex_error;
  END IF;
  EXCEPTION 
    WHEN ex_error THEN
      DBMS_OUTPUT.PUT_LINE ('Day la khong tam giac.');
END;