package Repository;

import Entity.Department;

import java.util.List;

public interface DepartmentRepository {
    void insertDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int departmentId);
    Department getDepartment(int departmentId);
    List<Department> getAllDepartments();
}
