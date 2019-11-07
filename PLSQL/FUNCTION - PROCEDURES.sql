CREATE OR REPLACE PROCEDURE "INSERTUSER"
  (
    id   IN NUMBER,
    name IN VARCHAR2
  )
IS
BEGIN
  INSERT INTO user_test VALUES
    (id,name);
END;

DECLARE
BEGIN   
   insertuser(102,'Rahul');  
   dbms_output.put_line('record inserted successfully');    
END;

SELECT * FROM USER_TEST;


CREATE OR REPLACE FUNCTION GIAI_THUA(
    n IN NUMBER )
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
END FACT;

DECLARE
  result NUMBER;
  x NUMBER;
BEGIN
  x := &x;
  result := GIAI_THUA(x);
  DBMS_OUTPUT.put_line('Result: ' || result);
END;

