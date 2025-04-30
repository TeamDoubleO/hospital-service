-- ==========================
-- HOSPITAL 테이블 더미 데이터
-- ==========================
INSERT INTO hospital (tenant_id, hospital_name, hospital_policy)
VALUES
    (101, '서울대학교병원', 1),
    (102, '삼성서울병원', 2),
    (103, '연세세브란스병원', 1);


-- ==========================
-- BUILDING 테이블 더미 데이터
-- ==========================
INSERT INTO building (tenant_id, building_name, building_code)
VALUES
    (101, '서울대학교병원 본관', 'SNUH_MAIN'),
    (101, '서울대학교병원 어린이병원', 'SNUH_CHILD'),
    (102, '삼성서울병원 본관', 'SSUH_MAIN'),
    (102, '삼성서울병원 암센터', 'SSUH_CANCER'),
    (103, '연세세브란스병원 본관', 'YONSEI_MAIN'),
    (103, '연세세브란스병원 심장혈관센터', 'YONSEI_HEART');
