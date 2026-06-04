package lab11.part2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductDao dao = new ProductDaoImplementare();

        // CREATE
        System.out.println("CREATE");
        Product p1 = dao.create(new Product("laptop", "electronice", 3500.0, 10));
        Product p2 = dao.create(new Product("telefon", "electronice", 2000.0, 25));
        Product p3 = dao.create(new Product("masa", "mobilier", 800.0, 5));
        System.out.println("CREAT ---->>> " + p1);
        System.out.println("CREAT ---->> " + p2);
        System.out.println("CREAT --->>> " + p3);

        // FIND ALL
        System.out.println();
        System.out.println("FIND ALL");
        List<Product> toate = dao.findAll();
        toate.forEach(System.out::println);

        // FIND BY ID
        System.out.println();
        System.out.println("FIND BY ID");
        Product gasit = dao.findById(p1.getId());
        System.out.println("GASIT ---->>> " + gasit);

        // FIND BY ID ->>>> exceptie custom
        try {
            dao.findById(9999);
        } catch (ProductNotFoundException e) {
            System.out.println("EXCEPTIE --->> " + e.getMessage());
        }

        // FIND BY CATEGORY
        System.out.println();
        System.out.println("FIND BY CATEGORY");
        List<Product> electronice = dao.findByCategory("electronice");
        electronice.forEach(System.out::println);

        // UPDATE
        System.out.println();
        System.out.println("UPDATE");
        boolean updated = dao.updatePriceAndStock(p1.getId(), 3200.0, 8);
        System.out.println("UPDATE REUSIT --->>>> " + updated);
        System.out.println("DUPA UPDATE ---->>>> " + dao.findById(p1.getId()));

        // DELETE
        System.out.println();
        System.out.println("DELETE");
        boolean deleted = dao.deleteById(p3.getId());
        System.out.println("DELETE REUSIT ----->>>> " + deleted);
        System.out.println("DUPA DELETE --- TOATE PRODUSELEEEE --->>>>");
        dao.findAll().forEach(System.out::println);
    }
}
