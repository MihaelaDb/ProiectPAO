package dao;

import model.ContEconomii;
import util.DatabaseUtil;

import java.sql.*;
import java.util.Optional;

public class ContEconomiiDao {

    public ContEconomiiDao() {
        createIfNotExists();
    }

    private void createIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS cont_economii (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "data_inceput DATE NOT NULL," +
                "data_finalizare DATE NOT NULL," +
                "dobanda DOUBLE NOT NULL," +
                "suma DOUBLE NOT NULL," +
                "nume_client VARCHAR(255) NOT NULL," +
                "prenume_client VARCHAR(255) NOT NULL" +
                ");";

        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Checked/created the table 'cont_economii' successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table 'cont_economii'.");
        }
    }

    public int create(ContEconomii contEconomii) {
        String query = "INSERT INTO cont_economii (data_inceput, data_finalizare, dobanda, suma) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, new java.sql.Date(contEconomii.getDataInceput().getTime()));
            statement.setDate(2, new java.sql.Date(contEconomii.getDataFinalizare().getTime()));
            statement.setDouble(3, contEconomii.getDobanda());
            statement.setDouble(4, contEconomii.getSuma());
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
            System.out.println("Error creating cont economii.");
        }
        return -1;
    }

    public Optional<ContEconomii> getById(int id) {
        String query = "SELECT * FROM cont_economii WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date dataInceput = resultSet.getDate("data_inceput");
                Date dataFinalizare = resultSet.getDate("data_finalizare");
                double dobanda = resultSet.getDouble("dobanda");
                double suma = resultSet.getDouble("suma");
                ContEconomii contEconomii = new ContEconomii(dataInceput, dataFinalizare, (int) dobanda, suma);
                return Optional.of(contEconomii);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching cont economii with id: " + id);
        }
        return Optional.empty();
    }

    public void updateSuma(int id, double newSuma) {
        String query = "UPDATE cont_economii SET suma = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, newSuma);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating suma in cont economii with id: " + id);
        }
    }
}
