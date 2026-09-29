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

        // Inicializa los datos de la clase padre.
        super(nombre, telefono);

        if (!"Boxeo".equals(disciplina)
                && !"MMA".equals(disciplina)
                && !"Jiu-jitsu".equals(disciplina)) {

            throw new IllegalArgumentException(
                    "Selecciona una disciplina válida.");
        }

        if (costoMensualidad <= 0) {
            throw new IllegalArgumentException(
                    "La mensualidad debe ser mayor que cero.");
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

    // Registra un pago después de validar su importe.
    public void registrarPago(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El pago debe ser mayor que cero.");
        }

        if (monto > calcularSaldoPendiente()) {
            throw new IllegalArgumentException(
                    "El pago no puede superar el saldo pendiente.");
        }

        pagos.add(monto);
    }

    // Inicia la suma desde la posición cero.
    public int calcularTotalPagado() {
        return sumarPagosRecursivo(0);
    }

    // Suma los pagos usando recursividad.
    private int sumarPagosRecursivo(int indice) {
        // Caso base: ya no hay más pagos.
        if (indice == pagos.size()) {
            return 0;
        }

        // Suma el pago actual y avanza al siguiente.
        return pagos.get(indice)
                + sumarPagosRecursivo(indice + 1);
    }

    // Calcula el dinero que falta pagar.
    public int calcularSaldoPendiente() {
        return costoMensualidad - calcularTotalPagado();
    }

    // Indica si la mensualidad está cubierta.
    public boolean estaPagada() {
        return calcularSaldoPendiente() == 0;
    }

    // Cuenta los pagos registrados.
    public int contarPagos() {
        return pagos.size();
    }

    // Permite consultar un pago sin entregar la lista completa.
    public int obtenerPago(int indice) {
        if (indice < 0 || indice >= pagos.size()) {
            throw new IllegalArgumentException(
                    "El pago solicitado no existe.");
        }

        return pagos.get(indice);
    }
}
