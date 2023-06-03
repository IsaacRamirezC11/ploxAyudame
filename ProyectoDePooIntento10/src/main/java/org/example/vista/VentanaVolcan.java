package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaVolcan extends JFrame {
    //Labels
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblUbicacion;
    private JLabel lblAltura;
    private JLabel lblEstado;
    private JLabel lblUrlFoto;
    private JLabel lblNewId;
    private JLabel lblNewNombre;
    private JLabel lblNewUbicacion;
    private JLabel lblNewAltura;
    private JLabel lblNewEstado;
    private JLabel lblNewUrlFoto;

    //TextFields
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtUbicacion;
    private JTextField txtAltura;
    private JTextField txtEstado;
    private JTextField txtUrlFoto;
    private JTextField txtNewId;
    private JTextField txtNewNombre;
    private JTextField txtNewUbicacion;
    private JTextField txtNewAltura;
    private JTextField txtNewEstado;
    private JTextField txtNewUrlFoto;

    //Botones

    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnActualizar;
    private JButton btnBorrar;

    //Tabla
    private JTable tblVolcan;
    private JScrollPane scrollPane;
    private GridLayout layout;

    //Paneles
    private JPanel panel1;// formulario
    private JPanel panel2;// tabla
    private JPanel panel3; // imagen
    private JPanel panel4; // borrar y actualizar

    //Imagen
    private JLabel imagenVolcan;

    public VentanaVolcan(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //Panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(97, 198, 255));

        lblId = new JLabel("Id: ");
        lblNombre = new JLabel("Nombre: ");
        lblUbicacion = new JLabel("Ubicacion: ");
        lblAltura = new JLabel("Altura: ");
        lblEstado = new JLabel("Estado: ");
        lblUrlFoto = new JLabel("Foto: ");

        txtId = new JTextField(10);

        txtId.setText("0");
        txtId.setEnabled(false);

        txtNombre = new JTextField(30);
        txtUbicacion = new JTextField(30);
        txtAltura = new JTextField(20);
        txtEstado = new JTextField(20);
        txtUrlFoto = new JTextField(30);

        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);

        panel1.add(lblNombre);
        panel1.add(txtNombre);

        panel1.add(lblUbicacion);
        panel1.add(txtUbicacion);

        panel1.add(lblAltura);
        panel1.add(txtAltura);

        panel1.add(lblEstado);
        panel1.add(txtEstado);

        panel1.add(lblUrlFoto);
        panel1.add(txtUrlFoto);

        panel1.add(btnAgregar);


        //Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(11, 163, 250));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblVolcan = new JTable();
        scrollPane = new JScrollPane(tblVolcan);
        panel2.add(scrollPane);

        //Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(11, 163, 250));
        imagenVolcan = new JLabel("Foto del Volcan");
        panel3.add(imagenVolcan);


        //Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(97, 198, 255));
        //Datos nuevos
        lblNewNombre = new JLabel("New Volcan: ");
        lblNewUbicacion = new JLabel("New Ubicaion del Volcan: ");
        lblNewAltura = new JLabel("New Altura del Volcan : ");
        lblNewEstado = new JLabel("New Estado del Volcan: ");

        txtNewId = new JTextField(10);
        txtNewId.setText("0");
        txtNewId.setEnabled(false);

        txtNewNombre = new JTextField(30);
        txtNewUbicacion = new JTextField(30);
        txtNewAltura = new JTextField(20);
        txtNewEstado = new JTextField(20);
        txtNewUrlFoto = new JTextField(30);

        btnActualizar = new JButton("Actualizar");
        btnBorrar = new JButton("Borrar");
        //Agregamos al panel
        panel4.add(btnBorrar);

        panel4.add(lblNewNombre);
        panel4.add(txtNewNombre);
        panel4.add(lblNewUbicacion);
        panel4.add(txtNewUbicacion);
        panel4.add(lblNewAltura);
        panel4.add(txtNewAltura);
        panel4.add(lblNewEstado);
        panel4.add(txtNewEstado);
        panel4.add(lblNewUrlFoto);
        panel4.add(txtNewUrlFoto);

        panel4.add(btnActualizar);


        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblUbicacion() {
        return lblUbicacion;
    }

    public void setLblUbicacion(JLabel lblUbicacion) {
        this.lblUbicacion = lblUbicacion;
    }

    public JLabel getLblAltura() {
        return lblAltura;
    }

    public void setLblAltura(JLabel lblAltura) {
        this.lblAltura = lblAltura;
    }

    public JLabel getLblEstado() {
        return lblEstado;
    }

    public void setLblEstado(JLabel lblEstado) {
        this.lblEstado = lblEstado;
    }

    public JLabel getLblUrlFoto() {
        return lblUrlFoto;
    }

    public void setLblUrlFoto(JLabel lblUrlFoto) {
        this.lblUrlFoto = lblUrlFoto;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }

    public void setTxtUbicacion(JTextField txtUbicacion) {
        this.txtUbicacion = txtUbicacion;
    }

    public JTextField getTxtAltura() {
        return txtAltura;
    }

    public void setTxtAltura(JTextField txtAltura) {
        this.txtAltura = txtAltura;
    }

    public JTextField getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(JTextField txtEstado) {
        this.txtEstado = txtEstado;
    }

    public JTextField getTxtUrlFoto() {
        return txtUrlFoto;
    }

    public void setTxtUrlFoto(JTextField txtUrlFoto) {
        this.txtUrlFoto = txtUrlFoto;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblVolcan() {
        return tblVolcan;
    }

    public void setTblVolcan(JTable tblVolcan) {
        this.tblVolcan = tblVolcan;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getLblNewId() {
        return lblNewId;
    }

    public void setLblNewId(JLabel lblNewId) {
        this.lblNewId = lblNewId;
    }

    public JLabel getLblNewNombre() {
        return lblNewNombre;
    }

    public void setLblNewNombre(JLabel lblNewNombre) {
        this.lblNewNombre = lblNewNombre;
    }

    public JLabel getLblNewUbicacion() {
        return lblNewUbicacion;
    }

    public void setLblNewUbicacion(JLabel lblNewUbicacion) {
        this.lblNewUbicacion = lblNewUbicacion;
    }

    public JLabel getLblNewAltura() {
        return lblNewAltura;
    }

    public void setLblNewAltura(JLabel lblNewAltura) {
        this.lblNewAltura = lblNewAltura;
    }

    public JLabel getLblNewEstado() {
        return lblNewEstado;
    }

    public void setLblNewEstado(JLabel lblNewEstado) {
        this.lblNewEstado = lblNewEstado;
    }

    public JLabel getLblNewUrlFoto() {
        return lblNewUrlFoto;
    }

    public void setLblNewUrlFoto(JLabel lblNewUrlFoto) {
        this.lblNewUrlFoto = lblNewUrlFoto;
    }

    public JTextField getTxtNewId() {
        return txtNewId;
    }

    public void setTxtNewId(JTextField txtNewId) {
        this.txtNewId = txtNewId;
    }

    public JTextField getTxtNewNombre() {
        return txtNewNombre;
    }

    public void setTxtNewNombre(JTextField txtNewNombre) {
        this.txtNewNombre = txtNewNombre;
    }

    public JTextField getTxtNewUbicacion() {
        return txtNewUbicacion;
    }

    public void setTxtNewUbicacion(JTextField txtNewUbicacion) {
        this.txtNewUbicacion = txtNewUbicacion;
    }

    public JTextField getTxtNewAltura() {
        return txtNewAltura;
    }

    public void setTxtNewAltura(JTextField txtNewAltura) {
        this.txtNewAltura = txtNewAltura;
    }

    public JTextField getTxtNewEstado() {
        return txtNewEstado;
    }

    public void setTxtNewEstado(JTextField txtNewEstado) {
        this.txtNewEstado = txtNewEstado;
    }

    public JTextField getTxtNewUrlFoto() {
        return txtNewUrlFoto;
    }

    public void setTxtNewUrlFoto(JTextField txtNewUrlFoto) {
        this.txtNewUrlFoto = txtNewUrlFoto;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JLabel getImagenVolcan() {
        return imagenVolcan;
    }

    public void setImagenVolcan(JLabel imagenVolcan) {
        this.imagenVolcan = imagenVolcan;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtUbicacion.setText("");
        txtAltura.setText("");
        txtEstado.setText("");
        txtUrlFoto.setText("");
    }
}
