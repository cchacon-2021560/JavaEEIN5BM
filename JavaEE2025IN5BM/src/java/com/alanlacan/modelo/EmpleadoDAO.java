package com.alanlacan.modelo;

import com.alanlacan.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

public class EmpleadoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

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

    public List listar() {
        String sql = "CALL sp_listarEmpleados();";
        List<Empleado> listaEmpleado = new ArrayList<>();
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombreEmpleado(rs.getString(2));
                em.setApellidoEmpleado(rs.getString(3));
                em.setDireccionEmpleado(rs.getString(4));
                em.setTelefonoEmpleado(rs.getString(5));
                em.setEmailEmpleado(rs.getString(6));
                em.setPuestoEmpleado(rs.getString(7));
                //atributos Empleado
                listaEmpleado.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    
    //METODO AGREGAR
    public int agregar(Empleado emp){
        String sql = "insert into Empleados (nombreEmpleado, apellidoEmpleado, direccionEmpleado, telefonoEmpleado, emailEmpleadog, puestoEmpleado) values (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidoEmpleado());
            ps.setString(3, emp.getDireccionEmpleado());
            ps.setString(4, emp.getTelefonoEmpleado());
            ps.setString(5, emp.getEmailEmpleado());
            ps.setString(6, emp.getPuestoEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return resp;
    }

}


/*public EmpleadoDAO()
         {
        emf = Persistence.createEntityManagerFactory("dominio"); // Asegúrate que el persistence unit "dominio" esté en persistence.xml
        em = emf.createEntityManager();
    }*/
    

    /*public void crearEmpleado(Empleado empleado) {
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
    }*/
