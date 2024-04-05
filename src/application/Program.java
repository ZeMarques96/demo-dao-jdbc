package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        // Department obj = new Department(1, "Books");
        // Seller seller = new Seller(21,"Bob","bob@mail.com", new Date(), 3000.00, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Find by ID === ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: Find by Department === ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for(Seller s : list) {
            System.out.println(s);
        }

        System.out.println("=== TEST 3: Find by All === ");
        List<Seller> list2 = sellerDao.findAll();

        for(Seller s : list2) {
            System.out.println(s);
        }
    }
}
