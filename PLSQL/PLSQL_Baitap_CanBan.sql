--B�i t?p 1: X�y d?ng kh?i l?nh t�nh n giai th?a
DECLARE 
   n number := &n; 
   x number := 1;
   lt number := 1;
BEGIN 
   WHILE x <= n LOOP 
      lt := lt * x; 
      x := x + 1; 
   END LOOP; 
   dbms_output.put_line(n||'! = '||lt);
END;

--B�i t?p 2: X�y d?ng kh?i l?nh xu?t b?ng c?u ch??ng th? n

DECLARE 
  n number := &n; 
  x number := 1;
  lt number := 1;
BEGIN 
  dbms_output.put_line('B?ng c?u ch??ng '||n||':');
  FOR x in 1 .. 10 LOOP 
      dbms_output.put_line(n||' x '||x||' = '||n*x); 
  END LOOP; 
END;

--B�i t?p 3: X�y d?ng kh?i l?nh gi?i ph??ng tr�nh b?c nh?t Ax + B = 0

DECLARE
  x FLOAT;
  a FLOAT := &a;
  b FLOAT := &b;
BEGIN
  IF (a = 0) THEN
    IF (b = 0) THEN
        dbms_output.put_line('Phuong trinh vo so nghiem');
      ELSE 
        dbms_output.put_line('Phuong trinh vo nghiem');
      END IF;
  ELSE  
    dbms_output.put_line('Phuong trinh co nghiem: x = '||(-b/a));
  END IF;
END;

--B�i t?p 4: X�y d?ng kh?i l?nh gi?i ph??ng tr�nh b?c nh?t



--B�i t?p 5: X�y d?ng kh?i l?nh nh?p 3 c?nh tam gi�c A,B,C. Cho bi?t tam gi�c c� 
--h?p l? kh�ng? N?u c� cho bi?t lo?i tam gi�c: ??u, c�n, vu�ng, vu�ng c�n, th??ng.

DECLARE
  A FLOAT := &A;
  B FLOAT := &B;
  C FLOAT := &C;
BEGIN
  IF ((A + B > C) and (A + C > B) and (B + C > A)) THEN
      dbms_output.put_line('Day la tam giac.');
      IF ((A = B) and (A = C)) THEN
        dbms_output.put_line('Day la tam giac deu.');
      ELSIF ((A = B) OR (A = C) OR (B = C)) THEN
        dbms_output.put_line('Day la tam giac can.');
      ELSIF ((A*A + B*B = C*C) OR (A*A + C*C = B*B) OR (C*C + B*B = A*A)) THEN
--          IF ((A = B) OR (A = C) OR (B = C)) THEN
--             dbms_output.put_line('Day la tam giac vuong can.');
--          ELSE
            dbms_output.put_line('Day la tam giac vuong.');
--          END IF;
      END IF;    
  ELSE
    dbms_output.put_line('Day la khong tam giac.');
  END IF;
END;

--B�i t?p 6: X�y d?ng kh?i l?nh nh?p ng�y, th�ng, n?m. Cho bi?t ng�y, th�ng, n?m c� h?p l? kh�ng?

DECLARE
  str_day INTEGER := &str_day;
  str_mon INTEGER := &str_mon;
  str_year INTEGER := &str_year;
  str_date varchar2(20);  
  v_date date;
BEGIN
  IF ((str_mon > 12) or (str_mon < 1)) THEN
    dbms_output.put_line('Thang khong hop le');
    ELSIF (str_mon in (1, 3, 5, 7, 8, 10, 12) AND ((str_day >31) or (str_day<0))) 
      THEN dbms_output.put_line('Ngay khong hop le');
  END IF;
  str_date := str_day||'-'||str_mon||'-'||str_year;
  dbms_output.put_line(v_date);
  
END;
