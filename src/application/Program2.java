package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST1: FIND BY ID ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);
        
        System.out.println();
        System.out.println("=== TEST2: FIND ALL ===");
        List<Department> departmentList = departmentDao.findAll();
        for (Department dep : departmentList){
            System.out.println(dep);
        }


        System.out.println("=== TEST3: INSERT ===");
        Department dep2 = new Department(null,"Tools");
        departmentDao.insert(dep2);
        System.out.println("DEPARTAMENTO DE ID: " + dep2.getId() + " INSERIDO.");
        
        System.out.println("=== TEST4: UPDATE ===");

        departmentList.sort(null);

        Department dep3 = departmentDao.findById(30);
        dep3.setName("Cars");
        departmentDao.update(dep3);
        departmentList = departmentDao.findAll();
        departmentList.sort(null);

        for(Department d : departmentList){
            System.out.println(d);
        }

        System.out.println();
        System.out.println("=== TEST5: DELETE ===");
        departmentDao.deleteById(31);
        System.out.println("That Id has been deleted!");


    }
}