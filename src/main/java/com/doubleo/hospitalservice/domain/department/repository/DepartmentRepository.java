package com.doubleo.hospitalservice.domain.department.repository;

import com.doubleo.hospitalservice.domain.department.domain.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> getDepartmentListByTenantId(Long tenantId);

    List<Department> findAllByTenantId(Long tenantId);
}
