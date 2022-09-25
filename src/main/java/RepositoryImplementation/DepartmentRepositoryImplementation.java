package RepositoryImplementation;

import Entity.Department;
import Repository.DepartmentRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DepartmentRepositoryImplementation implements DepartmentRepository {

    private HibernateTemplate hibernateTemplate;

    public DepartmentRepositoryImplementation(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public void insertDepartment(Department department) {
        hibernateTemplate.save(department);
    }

    @Transactional
    @Override
    public void updateDepartment(Department department) {
        hibernateTemplate.update(department);
    }

    @Transactional
    @Override
    public void deleteDepartment(int departmentId) {
        hibernateTemplate.delete(departmentId);
    }

    @Override
    public Department getDepartment(int departmentId) {
        return hibernateTemplate.get(Department.class, departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = hibernateTemplate.loadAll(Department.class);
        return departments;
    }
}
