package dao;


import model.SchimbValutar;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SchimbValutarDao {

    public SchimbValutarDao() {
        createIfNotExists();
    }

    private void createIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS schimb_valutar (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "suma DOUBLE NOT NULL," +
                "suma_schimbata DOUBLE" +
                ");";

        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(SchimbValutar schimbValutar) {
        String sql = "INSERT INTO schimb_valutar (suma) VALUES (?)";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setDouble(1, schimbValutar.getSuma());

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
        }
        return -1;
    }

    public void updateSumaSchimbata(int id, double sumaSchimbata) {
        String sql = "UPDATE schimb_valutar SET suma_schimbata = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, sumaSchimbata);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

