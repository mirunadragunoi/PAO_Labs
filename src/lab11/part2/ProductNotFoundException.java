package lab11.part2;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("PRODUSUL CU ID UL " + id + " NU A FOST GASIT!!!!!!!!");
    }
}
