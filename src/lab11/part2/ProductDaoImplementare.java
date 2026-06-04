package lab11.part2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplementare implements ProductDao {

    // functie ca sa mi construiesc efectiv un Product dintr un ResultSet
    private Product mapRow(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getDouble("price"),
                rs.getInt("stock")
        );
    }

    @Override
    public Product create(Product product) {
        String sql = "INSERT INTO products (name, category, price, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.executeUpdate();

            // iau id ul generat automat de baza de date
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                product.setId(keys.getInt(1));
            }

            return product;

        } catch (SQLException e) {
            throw new RuntimeException("EROARE LA CREATE!!!!!! " + e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("EROARE LA findAll!!!! " + e.getMessage());
        }

        return lista;
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapRow(rs);
            } else {
                throw new ProductNotFoundException(id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("EROARE LA findById!!! " + e.getMessage());
        }
    }

    @Override
    public List<Product> findByCategory(String category) {
        String sql = "SELECT * FROM products WHERE category = ?";
        List<Product> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("EROARE LA findByCategory!!!! " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean updatePriceAndStock(int id, double price, int stock) {
        String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, stock);
            ps.setInt(3, id);

            // cate randuri au fost modificare
            int randuri_modif = ps.executeUpdate();
            return randuri_modif > 0;

        } catch (SQLException e) {
            throw new RuntimeException("EROARE LA UPDATE!!!: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int randuri_modif = ps.executeUpdate();
            return randuri_modif > 0;

        } catch (SQLException e) {
            throw new RuntimeException("EROARE LA DELETE!!!! " + e.getMessage());
        }
    }
}
