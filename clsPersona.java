/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @author  Oswaldo Aldahir Flores Ramirez
 * @author LENOVO
 */
public class clsPersona {
     private String nombre;
    private String telefono;

    public clsPersona(String nombre, String telefono) {
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {throw new IllegalArgumentException("Escribe el nombre de la persona.");
        }

        this.nombre = nombre.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {throw new IllegalArgumentException("Escribe el teléfono.");
        }

        this.telefono = telefono.trim();
    }
}
