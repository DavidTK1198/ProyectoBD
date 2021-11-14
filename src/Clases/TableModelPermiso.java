package Clases;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPermiso extends AbstractTableModel{
    private List<String> filas;
    private final int[] columnas;
    private final String[] nombCol = {"Número","Permiso Disponible"};
   

    public TableModelPermiso(List<String> filas, int[] columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String username = filas.get(rowIndex);
        switch (columnIndex){
            case 0: return Integer.toString(rowIndex);
            case 1: return username;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column];
    }
    
    public String getRowAT(int n){
        return filas.get(n);
    }

}



