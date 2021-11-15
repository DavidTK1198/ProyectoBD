package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TableModelAuditoria extends DefaultTableModel {

    private final Service service = Service.instance();
    private final ArrayList<String> headers;
    private final ArrayList<RegistroDatos<String>> datos;

    public TableModelAuditoria() {
        super();
        this.headers = new ArrayList<>();
        this.datos = new ArrayList<>();
    }

    public void auditarConexiones() {
        cargarTabla(service.getConexion().getConnection(),
                "select username, action_name, priv_used, returncode from dba_audit_trail");
    }

    public void auditarTablas() {
        cargarTabla(service.getConexion().getConnection(),
                "select * from user_obj_audit_opts");
    }

    public void auditarTodos() {
        cargarTabla(service.getConexion().getConnection(),
                "select * from sys.dba_audit_trail");
    }

    public void auditarInsert() {
        cargarTabla(service.getConexion().getConnection(),
                "select * from sys.dba_audit_trail where action_name = 'INSERT'");
    }

    public void auditarSelect() {
        cargarTabla(service.getConexion().getConnection(),
                "select * from sys.dba_audit_trail where action_name = 'SELECT'");
    }

    public void auditarDelete() {
        cargarTabla(service.getConexion().getConnection(),
                "select * from sys.dba_audit_trail where action_name = 'DELETE'");
    }

    public void auditarUpdate() {
        cargarTabla(service.getConexion().getConnection(),
                "select * from sys.dba_audit_trail where action_name ='UPDATE'");
    }

    @Override
    public int getRowCount() {
        return (datos != null) ? datos.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return (datos.size() > 0) ? datos.get(0).getFieldCount() : 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos.get(rowIndex).get(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name;
        try {
            name = headers.get(columnIndex);
        } catch (IndexOutOfBoundsException ex) {
            name = String.format("Columna %d", columnIndex);
        }
        return name;
    }

    public void cargarTabla(Connection cnx, String selectCmd) {
        headers.clear();
        datos.clear();

        try (Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(selectCmd)) {

            // Carga los nombres de cada campo de la tabla
            // en la lista de encabezados.
            //
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                headers.add(rs.getMetaData().getColumnName(i + 1));
            }

            int n = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                RegistroDatos<String> row = new RegistroDatos<>();

                // Carga los datos asociados a cada campo en el registro.
                //
                for (int i = 0; i < n; i++) {
                    row.addFieldData(rs.getString(i + 1));
                }

                // Agrega el registro a la lista..
                //
                datos.add(row);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println(this);
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        for (int i = 0; i < datos.size(); i++) {
            r.append(String.format("\t%s,%n", datos.get(i)));
        }
        r.append("]");
        return r.toString();
    }

    class RegistroDatos<T> {

        private final List<T> row;

        public RegistroDatos() {
            row = new ArrayList<>();
        }

        public void addFieldData(T data) {
            row.add(data);
        }

        public T get(int index) {
            return row.get(index);
        }

        public int getFieldCount() {
            return row.size();
        }

        @Override
        public String toString() {
            StringBuilder r = new StringBuilder();
            for (int i = 0; i < getFieldCount(); i++) {
                r.append(String.format("%s", get(i)));
                if (i < (getFieldCount() - 1)) {
                    r.append(", ");
                }
            }
            return r.toString();
        }

    }

}
