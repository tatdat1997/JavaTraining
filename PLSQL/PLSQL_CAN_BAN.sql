--B�i t?p 1: X�y d?ng kh?i l?nh t�nh n giai th?a
DECLARE 
   n number := &n; 
   gthua number := 1;
BEGIN 
  IF (n = 0) THEN
    dbms_output.put_line(n||'! = 1');
  ELSIF (n < 0) THEN
    dbms_output.put_line('Giai thua khong the la so am');
  ELSE
   FOR x in 1 .. n LOOP
      gthua := gthua * x; 
   END LOOP; 
    dbms_output.put_line(n||'! = '|| gthua);
  END IF;
END;

--B�i t?p 2: X�y d?ng kh?i l?nh xu?t b?ng c?u ch??ng th? n

DECLARE 
  n number := &n; 
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

--B�i t?p 4: X�y khoi lenh giai phuong trinh bac hai

DECLARE
  x1 FLOAT;
  X2 FLOAT;
  delta FLOAT;
  a FLOAT := &a;
  b FLOAT := &b;
  c FLOAT := &c;
BEGIN
  IF(a = 0) THEN
    IF (b = 0) THEN
      IF (c = 0) THEN 
        dbms_output.put_line('Phuong trinh vo so nghiem');
      ELSE
        dbms_output.put_line('Phuong trinh vo nghiem');
      END IF;
    ELSE
      dbms_output.put_line('Phuong trinh co nghiem  x = '|| -c/b);
    END IF;
  ELSE
    delta := b**2 - 4 * (a * c);
    IF (delta < 0) THEN
      dbms_output.put_line('Phuong trinh vo nghiem');
    ELSIF (delta = 0) THEN
      dbms_output.put_line('Phuong trinh co nghiem kep x1 = x2 = '||(-b / (2 * a)));
    ELSE
      x1 := (-b + SQRT( delta )) / (2 * a);
      x2 := (-b - SQRT( delta )) / (2 * a);
      dbms_output.put_line('Phuong trinh co nghiem x1 = '||x1);
      dbms_output.put_line('Phuong trinh co nghiem x2 = '||x2);
    END IF;
  END IF;
END;


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
      ELSIF ((A**2 + B**2 = C**2) OR (A**2 + C**2 = B**2) OR (C**2 + B**2 = A**2)) THEN
          IF ((A = B) OR (A = C) OR (B = C)) THEN
             dbms_output.put_line('Day la tam giac vuong can.');
          ELSE
            dbms_output.put_line('Day la tam giac vuong.');
          END IF;
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
  IF ((str_day <= 0) or (str_mon <= 0) or (str_year <= 1941)) THEN
    dbms_output.put_line('Ngay thang nam khong hop le');
    ELSIF ((str_day > 31) or (str_mon > 12) or (str_year > 3000)) THEN
      dbms_output.put_line('Ngay thang nam khong hop le');
    ELSIF (str_mon in (1, 3, 5, 7, 8, 10, 12) AND (str_day <= 31)) THEN
      dbms_output.put_line('Ngay thang nam hop le');
    ELSIF (str_mon in (4, 6, 9, 11) AND (str_day <= 30)) THEN
      dbms_output.put_line('Ngay thang nam hop le');
    ELSIF ((str_mon = 2) AND (str_day >= 30)) THEN
      dbms_output.put_line('Ngay thang nam khong hop le 1');
    ELSIF ((str_mon = 2) AND (MOD(str_year, 400) = 0) AND (str_day <= 29)) THEN
      dbms_output.put_line('Nam nay la nam nhuan. Ngay hop le');
    ELSIF ( (str_mon = 2) AND ((MOD(str_year, 4) = 0)) AND (MOD(str_year, 100) != 0)) THEN
      dbms_output.put_line('Nam nay la nam nhuan. Ngay hop le');
    ELSIF ((str_mon = 2) AND ((MOD(str_year, 4) != 0)) AND (str_day <= 28)) THEN 
      dbms_output.put_line('Nam nay khong la nam nhuan. Ngay hop le');
    ELSE
      dbms_output.put_line('Ngay thang nam khong hop le');
  END IF;
END;

--Bai tap 7

DECLARE
  A FLOAT := &A;
  B FLOAT := &B;
  C FLOAT := &C;
  FLAT NUMBER :=-1;
BEGIN
  IF ((A + B > C) and (A + C > B) and (B + C > A)) THEN
      FLAT := 1;
      IF ((A = B) and (A = C)) THEN
        FLAT := 2;       
      ELSIF ((A = B) OR (A = C) OR (B = C)) THEN
        FLAT := 3;       
      ELSIF ((A**2 + B**2 = C**2) OR (A**2 + C**2 = B**2) OR (C**2 + B**2 = A**2)) THEN
          IF ((A = B) OR (A = C) OR (B = C)) THEN
            FLAT := 4;            
          ELSE
            FLAT := 5;
          END IF;
      END IF;    
  END IF;
  CASE FLAT 
    WHEN 1 THEN dbms_output.put_line('Day la mot tam giac.');
    WHEN 2 THEN dbms_output.put_line('Day la tam giac deu.');
    WHEN 3 THEN dbms_output.put_line('Day la tam giac can.'); 
    WHEN 4 THEN dbms_output.put_line('Day la tam giac vuong can.');
    WHEN 5 THEN dbms_output.put_line('Day la tam giac vuong.');
    ELSE dbms_output.put_line('Day khong la tam giac.');
  END CASE;
END;

DECLARE
  A NUMBER := 123;
  B NUMBER := 987;
BEGIN
--  FOR X in 100 .. 1000 LOOP
--    IF (MOD(X,111) = 0) THEN
--      dbms_output.put_line(X||' ');
--    END IF;
--  END LOOP;
--  dbms_output.put_line(A||' '||B);
--  FOR X in 1 .. 6 LOOP
--    A := A + 111;
--    B := B - 111;
--    dbms_output.put_line(A||' '||B);
--  END LOOP; 
  dbms_output.put_line(DBMS_RANDOM.VALUE(1,90));

END;

