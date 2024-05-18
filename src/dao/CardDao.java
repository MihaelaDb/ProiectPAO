package dao;

import model.Card;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardDao implements Dao<Card> {

    public CardDao() {
        createIfNotExists();
    }

    private void createIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS card (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "numar_card VARCHAR(30) NOT NULL," +
                "cvv VARCHAR(20) NOT NULL," +
                "data_expirarii DATE NOT NULL" +
                ");";

        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Checked/created the table 'card' successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table 'card'.");
        }
    }

    @Override
    public Optional<Card> get(int id) {
        String query = "SELECT * FROM card WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String numarCard = resultSet.getString("numar_card");
                String cvv = resultSet.getString("cvv");
                Date dataExpirarii = resultSet.getDate("data_expirarii");
                Card card = new Card(id, numarCard, cvv, dataExpirarii);
                return Optional.of(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching card with id: " + id);
        }
        return Optional.empty();
    }

    @Override
    public List<Card> getAll() {
        List<Card> cards = new ArrayList<>();
        String query = "SELECT * FROM card";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String numarCard = resultSet.getString("numar_card");
                String cvv = resultSet.getString("cvv");
                Date dataExpirarii = resultSet.getDate("data_expirarii");
                Card card = new Card(id, numarCard, cvv, dataExpirarii);
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching all cards.");
        }
        return cards;
    }

    @Override
    public int create(Card card) {
        String query = "INSERT INTO card (numar_card, cvv, data_expirarii) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, card.getNumarCard());
            statement.setInt(2, card.getCVV());
            statement.setDate(3, card.getDataExpirarii());
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
            System.out.println("Error creating card.");
        }
        return -1;
    }


    @Override
    public void update(int id, Card card) {
        String query = "UPDATE card SET nume = ?, prenume = ?, numar_card = ?, cvv = ?, data_expirarii = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, card.getNume());
            statement.setString(2, card.getPrenume());
            statement.setString(3, card.getNumarCard());
            statement.setInt(4, card.getCVV());
            statement.setDate(5, card.getDataExpirarii());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating card with id: " + id);
        }
    }

    @Override
    public void delete(Card card) {
        String query = "DELETE FROM card WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, card.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting card with id: " + card.getId());
        }
    }
}
