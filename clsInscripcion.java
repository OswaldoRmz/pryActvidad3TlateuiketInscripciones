/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
/**
 * @author Oswaldo Aldahir Flores Ramirez
 * @author LENOVO
 */
public class clsInscripcion extends clsPersona{
    private String disciplina;
    private int costoMensualidad;
    private ArrayList<Integer> pagos;

    public clsInscripcion(String nombre, String telefono,
            String disciplina, int costoMensualidad) {
        
        super(nombre, telefono);

        if (!"Boxeo".equals(disciplina)&& !"MMA".equals(disciplina)&& !"Jiu-jitsu".equals(disciplina)) {

            throw new IllegalArgumentException("Selecciona una disciplina válida.");
        }

        if (costoMensualidad <= 0) {
            throw new IllegalArgumentException("La mensualidad debe ser mayor que cero.");
        }

        this.disciplina = disciplina;
        this.costoMensualidad = costoMensualidad;
        this.pagos = new ArrayList<Integer>();
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getCostoMensualidad() {
        return costoMensualidad;
    }

    public void registrarPago(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El pago debe ser mayor que cero.");
        }

        if (monto > calcularSaldoPendiente()) {
            throw new IllegalArgumentException("El pago no puede superar el saldo pendiente.");
        }

        pagos.add(monto);
    }

    public int calcularTotalPagado() {
        return sumarPagosRecursivo(0);
    }

    private int sumarPagosRecursivo(int indice) {
        // Caso base: ya no hay más pagos.
        if (indice == pagos.size()) {
            return 0;
        }
        
        return pagos.get(indice)
                + sumarPagosRecursivo(indice + 1);
    }

    public int calcularSaldoPendiente() {
        return costoMensualidad - calcularTotalPagado();
    }

    public boolean estaPagada() {
        return calcularSaldoPendiente() == 0;
    }
   
    public int contarPagos() {
        return pagos.size();
    }

    public int obtenerPago(int indice) {
        if (indice < 0 || indice >= pagos.size()) {
            throw new IllegalArgumentException("El pago solicitado no existe.");
        }

        return pagos.get(indice);
    }
}
