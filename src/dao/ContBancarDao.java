package dao;

import model.ContBancar;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Optional;

public class ContBancarDao {
    public ContBancarDao() {
        createIfNotExists();
    }

    private void createIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS cont_bancar (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "iban VARCHAR(255) NOT NULL," +
                "swift VARCHAR(255) NOT NULL," +
                "sold DOUBLE NOT NULL" +
                ");";

        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
            System.out.println("Checked/created the table 'cont_bancar' successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table 'cont_bancar'.");
        }
    }

    public int create(ContBancar contBancar) {
        String sql = "INSERT INTO cont_bancar (id, iban, swift, sold) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, contBancar.getClientId());
            statement.setString(2, contBancar.getIban());
            statement.setString(3, contBancar.getSwift());
            statement.setDouble(4, contBancar.getSold());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating bank account.");
        }
        return -1;
    }

    public Optional<ContBancar> getById(int id) {
        String sql = "SELECT * FROM cont_bancar WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String iban = resultSet.getString("iban");
                String swift = resultSet.getString("swift");
                double sold = resultSet.getDouble("sold");
                ContBancar contBancar = new ContBancar(id, iban, swift, sold);
                return Optional.of(contBancar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching bank account with id: " + id);
        }
        return Optional.empty();
    }


    public void update(int id, ContBancar contBancar) {
        String sql = "UPDATE cont_bancar SET iban = ?, swift = ?, sold = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, contBancar.getIban());
            statement.setString(2, contBancar.getSwift());
            statement.setDouble(3, contBancar.getSold());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating bank account with id: " + id);
        }
    }

    public void delete(ContBancar contBancar) {
        String sql = "DELETE FROM cont_bancar WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, contBancar.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting bank account with id: " + contBancar.getId());
        }
    }

    public void updateAmount(int id, double newAmount) {
        String sql = "UPDATE cont_bancar SET sold = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newAmount);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating amount for bank account with id: " + id);
        }
    }

}
