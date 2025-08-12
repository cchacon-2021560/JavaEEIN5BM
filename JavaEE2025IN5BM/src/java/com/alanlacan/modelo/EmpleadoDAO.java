package com.alanlacan.modelo;

import com.alanlacan.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    int resp;

    public Empleado validar(String emailEmpleado, String telefonoEmpleado) {
        //instanciar el objeto de la entidad Empleado
        Empleado empleado = new Empleado();
        //agregar una variable de tipo string para muestra de consulta sql
        String sql = "select * from Empleados where emailEmpleado = ? and telefonoEmpleado = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, emailEmpleado);
            ps.setString(2, telefonoEmpleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombreEmpleado("nombreEmpleado");
                empleado.setApellidoEmpleado("apellidoEmpleado");
                empleado.setDireccionEmpleado("direccionEmpleado");
                empleado.setTelefonoEmpleado("telefonoEmpleado");
                empleado.setEmailEmpleado("emailEmpleado");
                empleado.setPuestoEmpleado("puestoEmpleado");
            }
        } catch (Exception e) {
            System.out.println("El usuario o contraseña son incorrectos");
            e.printStackTrace();
        }
        return empleado; //Empleado Encontrado
    }

}
 
/*
    public void crearEmpleado(Empleado empleado) {
        try {
            em.getTransaction().begin();
            em.persist(empleado); 
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public Empleado buscarEmpleado(int codigoEmpleado) {
        return em.find(Empleado.class, codigoEmpleado);
    }
    public void actualizarEmpleado(Empleado empleado) {
        try {
            em.getTransaction().begin();
            em.merge(empleado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void eliminarEmpleado(int codigoEmpleado) {
        try {
            Empleado empleado = em.find(Empleado.class, codigoEmpleado);
            if (empleado != null) {
                em.getTransaction().begin();
                em.remove(empleado); 
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public List<Empleado> listarEmpleado() {
        return em.createQuery("SELECT e From Empleado e", Empleado.class).getResultList();
    }
    public void cerrar() {
        em.close();
        emf.close();
    }
}*/
