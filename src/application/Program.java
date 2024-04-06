package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        // Department obj = new Department(1, "Books");
        // Seller seller = new Seller(21,"Bob","bob@mail.com", new Date(), 3000.00, obj);
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println();
        System.out.println("=== TEST 1: Find by ID === ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println();
        System.out.println("=== TEST 2: Find by Department === ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for(Seller s : list) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("=== TEST 3: Find by All === ");
        List<Seller> list2 = sellerDao.findAll();

        for(Seller s : list2) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("=== TEST 4: Seller Insert === ");
        Seller newSeller = new Seller(null, "Greg", "greg@mail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println();
        System.out.println("=== TEST 5: Seller Update === ");
        seller = sellerDao.findById(28);
        seller.setName("Martha Waine");
        seller.setEmail("martha@mail.com");
        sellerDao.update(seller);
        System.out.println("Update Complete!");
        
        System.out.println();
        System.out.println("=== TEST 5: DELETE === ");
        System.out.print("Enter id for delete test: ");
        int delId = sc.nextInt();
        sellerDao.deleteById(delId);
        System.out.println("Delete Complete!");


        DB.closeConnection();


        sc.close();
    }
}
