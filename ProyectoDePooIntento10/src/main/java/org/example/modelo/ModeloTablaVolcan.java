package org.example.modelo;

import org.example.persistencia.VolcanDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaVolcan implements TableModel {
    public static final int COLUMS = 6;
    private ArrayList<Volcanes> datos;
    private VolcanDAO vdao;

    public ModeloTablaVolcan() {
        vdao = new VolcanDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaVolcan(ArrayList<Volcanes> datos) {
        this.datos = datos;
        vdao = new VolcanDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Ubicacion";
            case 3:
                return "Altura";
            case 4:
                return "Estado";
            case 5:
                return "Foto";
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Volcanes tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getUbicacion();
            case 3:
                return tmp.getAltura();
            case 4:
                return tmp.getEstado();
            case 5:
                return tmp.getUrlFoto();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).getId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setUbicacion((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setAltura((int) aValue);
                break;
            case 4:
                datos.get(rowIndex).setEstado((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrlFoto((String) aValue);
                break;
            default:
                System.out.println("No se modifico nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos(){
        try {
            ArrayList<Volcanes> tirar = vdao.obtenerTodo();
            System.out.println(tirar);
            datos = vdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }

    public boolean agregarVolcan(Volcanes volcan){
        boolean resultado = false;

        try {
            if (vdao.insertar(volcan)) {
                datos.add(volcan);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean borrarVolcan(String index){
        boolean resultado = false;
        try{
            if (vdao.delete(index)){
                System.out.println("Se elimino el volcan");
                resultado = true;
            }else{
                System.out.println("El volcan no se pudo borrar");
                System.out.println(index);
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


    public Volcanes getVolcanAtIndex(int idx){
        return datos.get(idx);
    }

    public boolean actualizarVolcan(Volcanes volcan){
        boolean resultado = false;
        try {
            if (vdao.update(volcan)){
                System.out.println("Se modifico el volcan");
                resultado = true;
            }else {
                resultado = false;
                System.out.println("No se pudo modificar el volcan");
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

}

