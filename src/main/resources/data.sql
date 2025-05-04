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


-- ==========================
-- AREA 테이블 더미 데이터
-- ==========================

-- 서울대학교병원 본관 구역
INSERT INTO area (tenant_id, building_id, area_name, area_code)
VALUES
    (101, 1, '진료구역 101', 'SNUH_MAIN_101'),
    (101, 1, '진료구역 102', 'SNUH_MAIN_102');

-- 서울대학교병원 어린이병원 구역
INSERT INTO area (tenant_id, building_id, area_name, area_code)
VALUES
    (101, 2, '소아진료실 1', 'SNUH_CHILD_1'),
    (101, 2, '소아진료실 2', 'SNUH_CHILD_2');

-- 삼성서울병원 본관 구역
INSERT INTO area (tenant_id, building_id, area_name, area_code)
VALUES
    (102, 3, '외래 101', 'SSUH_MAIN_101'),
    (102, 3, '외래 102', 'SSUH_MAIN_102');

-- 삼성서울병원 암센터 구역
INSERT INTO area (tenant_id, building_id, area_name, area_code)
VALUES
    (102, 4, '항암치료실 1', 'SSUH_CANCER_1');

-- 연세세브란스병원 본관 구역
INSERT INTO area (tenant_id, building_id, area_name, area_code)
VALUES
    (103, 5, '입원실 101', 'YONSEI_MAIN_101');

-- 연세세브란스병원 심장혈관센터 구역
INSERT INTO area (tenant_id, building_id, area_name, area_code)
VALUES
    (103, 6, '심장센터 진료실', 'YONSEI_HEART_1'),
    (103, 6, '검사실', 'YONSEI_HEART_2');