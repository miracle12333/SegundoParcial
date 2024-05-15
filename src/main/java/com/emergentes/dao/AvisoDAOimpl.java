package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimpl extends ConexionBD implements AvisoDAO {

    @Override
    public void insert(Aviso aviso) throws Exception {
        String sql = "insert into estudiantes  (nombres,apellidos,seminario,fecha_inscripcion) values (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getNombres());
        ps.setString(2, aviso.getApellidos());
        ps.setString(3, aviso.getSeminario());
        ps.setString(4, aviso.getFecha_inscripcion());
        ps.executeUpdate();
        this.desconectar();
    }

   @Override
public void update(Aviso avi) throws Exception {
    String sql = "UPDATE estudiantes SET nombres = ?, apellidos = ?, seminario = ?, fecha_inscripcion = ? WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, avi.getNombres());
        ps.setString(2, avi.getApellidos());
        ps.setString(3, avi.getSeminario());
        ps.setString(4, avi.getFecha_inscripcion());
        ps.setInt(5, avi.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new Exception("Error al actualizar el aviso", e);
    }
}

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from estudiantes where id=? ";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Aviso> getAll() throws Exception {
        List<Aviso> lista = null;
        String sql = "select * from estudiantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Aviso>();
        while (rs.next()) {
            Aviso avi = new Aviso();
            avi.setId(rs.getInt("id"));
            avi.setNombres(rs.getString("nombres"));
            avi.setApellidos(rs.getString("apellidos"));
            avi.setSeminario(rs.getString("seminario"));
            avi.setFecha_inscripcion(rs.getString("fecha_inscripcion"));
            lista.add(avi);

        }
        this.desconectar();
        return lista;

    }

    @Override
    public Aviso getById(int id) throws Exception {
        Aviso avi = new Aviso();
        try {
            String sql = "select * from estudiantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setNombres(rs.getString("nombres"));
                avi.setApellidos(rs.getString("apellidos"));
                avi.setSeminario(rs.getString("seminario"));
                avi.setFecha_inscripcion(rs.getString("fecha_inscripcion"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

}
