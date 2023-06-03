package org.example.persistencia;

import org.example.modelo.Volcanes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VolcanDAO implements InterfazDAO {


    public VolcanDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO volcanes(nombre,ubicacion,altura,estado,urlFoto) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("volcanesDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Volcanes) obj).getNombre());
        pstm.setString(2, ((Volcanes) obj).getUbicacion());
        pstm.setInt(3, ((Volcanes) obj).getAltura());
        pstm.setString(4, ((Volcanes) obj).getEstado());
        pstm.setString(5, ((Volcanes) obj).getUrlFoto());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE volcanes SET nombre = ?,ubicacion = ?, altura = ?, estado = ?, urlFoto = ? WHERE id = ?; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("volcanesDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Volcanes) obj).getNombre());
        pstm.setString(2, ((Volcanes) obj).getUbicacion());
        pstm.setInt(3, ((Volcanes) obj).getAltura());
        pstm.setString(4, ((Volcanes) obj).getEstado());
        pstm.setString(5, ((Volcanes) obj).getUrlFoto());
        pstm.setInt(6, ((Volcanes) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM volcanes WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("volcanesDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM volcanes";
        ArrayList<Volcanes> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("volcanesDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Volcanes(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6)));
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {


        String sql = "SELECT * FROM volcanes WHERE id;";
        Volcanes volcan = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("volcanesDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            volcan = new Volcanes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));
            return volcan;
        }
        return null;
    }
}
