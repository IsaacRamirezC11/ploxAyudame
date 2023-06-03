package org.example.controlador;

import org.example.modelo.ModeloTablaVolcan;
import org.example.modelo.Volcanes;
import org.example.vista.VentanaVolcan;
import org.example.persistencia.VolcanDAO;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

public class ControladorVolcan extends MouseAdapter {

    private VentanaVolcan view;
    private ModeloTablaVolcan modelo;

    public ControladorVolcan(VentanaVolcan view) {
        this.view = view;
        modelo = new ModeloTablaVolcan();
        this.view.getTblVolcan().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblVolcan().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()){
            modelo.cargarDatos();
            this.view.getTblVolcan().setModel(modelo);
            this.view.getTblVolcan().updateUI();

        }

        if (e.getSource() == this.view.getBtnAgregar()){
            Volcanes volcan = new Volcanes();
            volcan.setId(0);
            volcan.setNombre(this.view.getTxtNombre().getText());
            volcan.setUbicacion(this.view.getTxtUbicacion().getText());
            volcan.setAltura(Integer.parseInt(this.view.getTxtAltura().getText()));
            volcan.setEstado(this.view.getTxtEstado().getText());
            volcan.setUrlFoto(this.view.getTxtUrlFoto().getText());
            if(modelo.agregarVolcan(volcan)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente el volcan","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblVolcan().updateUI();
            }else {
                JOptionPane.showMessageDialog(view,"No se pudo agregar el volcan a la base","Error al insertar volcan",JOptionPane.ERROR_MESSAGE);
            }

            this.view.limpiar();

        }

        if (e.getSource() == view.getTblVolcan()){
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTblVolcan().getSelectedRow();
            Volcanes tmp = modelo.getVolcanAtIndex(index);
            try {
                this.view.getImagenVolcan().setIcon(tmp.getImagen());

            }catch (MalformedURLException mfeu){
                System.out.println(e.toString());
            }

        }

        if (e.getSource() == this.view.getBtnBorrar()){
            int row = this.view.getTblVolcan().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row,0));

            System.out.println(index);

            int respuesta = JOptionPane.showConfirmDialog(view,"Estas seguro de borrar el volcan?","Seleciona un volcan",JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION){
                modelo.borrarVolcan(index);
                JOptionPane.showMessageDialog(view,"El volcan fue borrado", "Aviso",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(view,"El volcan no fue eliminado","Error al borrar el volcan",JOptionPane.ERROR_MESSAGE);
            }
            modelo.cargarDatos();
            this.view.getTblVolcan().setModel(modelo);
            this.view.getTblVolcan().updateUI();
            this.view.limpiar();
        }

        if (e.getSource() == this.view.getBtnActualizar()){
            int row = this.view.getTblVolcan().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row,0));

            Volcanes volcan = new Volcanes();

            volcan.setNombre(this.view.getTxtNewNombre().getText());
            volcan.setUbicacion(this.view.getTxtNewUbicacion().getText());
            volcan.setAltura(Integer.parseInt(this.view.getTxtNewAltura().getText()));
            volcan.setEstado(this.view.getTxtNewEstado().getText());
            volcan.setUrlFoto(this.view.getTxtNewUrlFoto().getText());
            volcan.setId(Integer.parseInt(index));

            if (modelo.actualizarVolcan(volcan)){
                JOptionPane.showMessageDialog(view,"Se ha modificado el volcan","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblVolcan().updateUI();
            }else {
                JOptionPane.showMessageDialog(view,"No se pudo modificar el volcan","Error",JOptionPane.ERROR_MESSAGE);
                this.view.getTblVolcan().updateUI();
            }
            modelo.cargarDatos();
            this.view.getTblVolcan().setModel(modelo);
            this.view.getTblVolcan().updateUI();
        }
        this.view.getTblVolcan().updateUI();
    }




}




