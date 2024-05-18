package dao;

import model.CursValutar;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursValutarDao {
    public CursValutarDao() {
        createIfNotExists();
    }

    private void createIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS curs_valutar (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "valuta_baza VARCHAR(255) NOT NULL," +
                "valuta_cotata VARCHAR(255) NOT NULL," +
                "rata_schimb DOUBLE NOT NULL," +
                "data_actualizare DATETIME NOT NULL," +
                "cod_valutar VARCHAR(255) NOT NULL" +
                ");";

        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
            System.out.println("Checked/created the table 'curs_valutar' successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table 'curs_valutar'.");
        }
    }

    public int create(CursValutar cursValutar) {
        String sql = "INSERT INTO curs_valutar (valuta_baza, valuta_cotata, rata_schimb, data_actualizare, cod_valutar) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cursValutar.getValutaBaza());
            statement.setString(2, cursValutar.getValutaCotata());
            statement.setDouble(3, cursValutar.getRataSchimb());
            statement.setObject(4, cursValutar.getDataActualizare());
            statement.setString(5, cursValutar.getCodValutar());
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
            System.out.println("Error creating curs valutar.");
        }
        return -1;
    }

    public List<CursValutar> getAll() {
        List<CursValutar> cursValutarList = new ArrayList<>();
        String sql = "SELECT * FROM curs_valutar";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String valutaBaza = resultSet.getString("valuta_baza");
                String valutaCotata = resultSet.getString("valuta_cotata");
                double rataSchimb = resultSet.getDouble("rata_schimb");
                LocalDateTime dataActualizare = resultSet.getObject("data_actualizare", LocalDateTime.class);
                String codValutar = resultSet.getString("cod_valutar");

                CursValutar cursValutar = new CursValutar(valutaBaza, valutaCotata, rataSchimb, dataActualizare, codValutar);
                cursValutarList.add(cursValutar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching all curs valutar.");
        }
        return cursValutarList;
    }


    public Optional<CursValutar> getById(int id) {
        String sql = "SELECT * FROM curs_valutar WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String valutaBaza = resultSet.getString("valuta_baza");
                String valutaCotata = resultSet.getString("valuta_cotata");
                double rataSchimb = resultSet.getDouble("rata_schimb");
                CursValutar cursValutar = new CursValutar(id, valutaBaza, valutaCotata, rataSchimb);
                return Optional.of(cursValutar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching CursValutar with id: " + id);
        }
        return Optional.empty();
    }

}
