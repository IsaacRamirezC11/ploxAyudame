package org.example;


import org.example.controlador.ControladorVolcan;
import org.example.persistencia.VolcanDAO;
import org.example.vista.VentanaVolcan;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        VentanaVolcan view = new VentanaVolcan("Proyecto Final POO");
        ControladorVolcan controller = new ControladorVolcan(view);

    }
}