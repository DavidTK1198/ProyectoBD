/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DavidTK1198
 */
public class Query {

    String consulta;
    private Map<String, String> tipos;

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public Query(String consulta) {
        this.consulta = consulta;
        tipos = new HashMap<>();
        this.initHashMap();
    }

    private void initHashMap() {
        tipos.put("1", "\n Usuario eliminado.");
        tipos.put("2", "\n Usuario Creado");
        tipos.put("3", "\n Rol Creado");
        tipos.put("4", "\n Rol Asignado");
        tipos.put("5", "\n Rol Eliminado.");
        tipos.put("6", "\n Rol revocado.");
        tipos.put("7", "\n Datafile agregado.");
        tipos.put("8", "\n TableSpace creado.");
        tipos.put("9", "\n TableSpace temporal creado.");
        tipos.put("10", "\n TableSpace eliminado.");
        tipos.put("11", "\n TableSpace extendido.");
        tipos.put("12", "\n TableSpace Compactado.");
        tipos.put("13", "\n Permiso concedido.");
        tipos.put("14", "\n Permiso Revocado.");
        tipos.put("15", "\n Tabla analizada.");
    }

    public Query() {
        tipos = new HashMap<>();
        this.initHashMap();
    }

    public ArrayList<String> cargarTablas(Service s, String Value) {
        ArrayList<String> tablas = new ArrayList<String>();
        try {

            Statement stm = s.getConexion().prepareStatement();
            ResultSet rs = s.getConexion().executeQuery(stm, this.consulta);
            while (rs.next()) {
                tablas.add(rs.getString(Value));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado de tipo de tablas");
        }
        return tablas;
    }

    public String executeQuery(Service s,String key) {
        try {
            Statement stm = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(stm, "alter session set \"_ORACLE_SCRIPT\" =true");
            ResultSet rs = s.getConexion().executeQuery(stm, this.consulta);
            return this.tipos.get(key);
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

}
