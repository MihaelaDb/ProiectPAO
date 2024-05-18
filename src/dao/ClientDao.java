package dao;

import model.Client;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<Client> {

    public ClientDao() {
        createIfNotExists();
    }

    private void createIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS client (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nume VARCHAR(255) NOT NULL," +
                "prenume VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "telefon VARCHAR(20) NOT NULL," +
                "data_nasterii DATE NOT NULL," +
                "adresa VARCHAR(255) NOT NULL" +
                ");";

        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Checked/created the table 'client' successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table 'client'.");
        }
    }

    @Override
    public Optional<Client> get(int id) {
        String query = "SELECT * FROM client WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nume = resultSet.getString("nume");
                    String prenume = resultSet.getString("prenume");
                    String email = resultSet.getString("email");
                    String telefon = resultSet.getString("telefon");
                    Date dataNasterii = resultSet.getDate("data_nasterii");
                    String adresa = resultSet.getString("adresa");
                    Client client = new Client(id, nume, prenume, email, telefon, dataNasterii, adresa);
                    return Optional.of(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error client cu id : " + id);
        }
        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String email = resultSet.getString("email");
                String telefon = resultSet.getString("telefon");
                Date dataNasterii = resultSet.getDate("data_nasterii");
                String adresa = resultSet.getString("adresa");
                Client client = new Client(id, nume, prenume, email, telefon, dataNasterii, adresa);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching all clients.");
        }
        return clients;
    }

    @Override
    public int create(Client client) {
        String query = "INSERT INTO client (nume, prenume, email, telefon, data_nasterii, adresa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelefon());
            statement.setDate(5, client.getDataNasterii());
            statement.setString(6, client.getAdresa());
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
            System.out.println("Error creating client.");
        }
        return -1;
    }

    @Override
    public void update(int id, Client client) {
        String query = "UPDATE client SET nume = ?, prenume = ?, email = ?, telefon = ?, data_nasterii = ?, adresa = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            System.out.println("Client email: " + client.getEmail());
            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            if (client.getEmail() != null) {
                statement.setString(3, client.getEmail());
            } else {
                statement.setNull(3, Types.VARCHAR);
            }
            statement.setString(4, client.getTelefon());
            statement.setDate(5, client.getDataNasterii());
            statement.setString(6, client.getAdresa());
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating client with id: " + id);
        }
    }

    @Override
    public void delete(Client client) {
        String query = "DELETE FROM client WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting client with id: " + client.getId());
        }
    }
    public Optional<Client> getClientById(int clientId) {
        String query = "SELECT * FROM client WHERE id = ?";
        try (Connection connection = DatabaseUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Client client = new Client(
                            resultSet.getInt("id"),
                            resultSet.getString("nume"),
                            resultSet.getString("prenume")
                    );
                    return Optional.of(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching client with id: " + clientId);
        }
        return Optional.empty();
    }
}
