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

-- ==========================
-- DEPARTMENT 테이블 더미 데이터
-- ==========================

-- 서울대학교병원 진료과 (tenantId: 101)
INSERT INTO department (tenant_id, department_name, department_code)
VALUES
    (101, '내과', 'INT'),
    (101, '외과', 'SUR'),
    (101, '소아청소년과', 'PED');

-- 삼성서울병원 진료과 (tenantId: 102)
INSERT INTO department (tenant_id, department_name, department_code)
VALUES
    (102, '신경과', 'NEU'),
    (102, '흉부외과', 'CTS'),
    (102, '피부과', 'DER');

-- 연세세브란스병원 진료과 (tenantId: 103)
INSERT INTO department (tenant_id, department_name, department_code)
VALUES
    (103, '정형외과', 'ORT'),
    (103, '산부인과', 'OBG'),
    (103, '비뇨의학과', 'URO');

