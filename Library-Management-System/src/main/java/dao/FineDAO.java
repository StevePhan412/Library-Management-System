package dao;

// src/dao/FineDAO.java

import entity.Fine;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FineDAO {

    public Fine getFine(int fineId) {
        Fine fine = null;
        String sql = "SELECT * FROM Fines WHERE fine_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fineId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fine = new Fine();
                fine.setFineId(rs.getInt("fine_id"));
                fine.setUserId(rs.getInt("user_id"));
                fine.setTotalFineAmount(rs.getDouble("total_fine_amount"));
                fine.setLastUpdated(rs.getDate("last_updated"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fine;
    }

    public List<Fine> getFines() {
        List<Fine> fines = new ArrayList<>();
        String sql = "SELECT * FROM Fines";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fine fine = new Fine();
                fine.setFineId(rs.getInt("fine_id"));
                fine.setUserId(rs.getInt("user_id"));
                fine.setTotalFineAmount(rs.getDouble("total_fine_amount"));
                fine.setLastUpdated(rs.getDate("last_updated"));
                fines.add(fine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fines;
    }

    public boolean createFine(Fine fine) {
        String sql = "INSERT INTO Fines (user_id, total_fine_amount, last_updated) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fine.getUserId());
            stmt.setDouble(2, fine.getTotalFineAmount());
            stmt.setDate(3, new java.sql.Date(fine.getLastUpdated().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFine(Fine fine) {
        String sql = "UPDATE Fines SET user_id = ?, total_fine_amount = ?, last_updated = ? WHERE fine_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fine.getUserId());
            stmt.setDouble(2, fine.getTotalFineAmount());
            stmt.setDate(3, new java.sql.Date(fine.getLastUpdated().getTime()));
            stmt.setInt(4, fine.getFineId());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFine(int fineId) {
        String sql = "DELETE FROM Fines WHERE fine_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fineId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

