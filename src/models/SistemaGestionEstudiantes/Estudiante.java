package models.SistemaGestionEstudiantes;

public class Estudiante {
    private String codigo;
    private String nombre;
    private float promedio;
    private Carrera Carrera;

    //Constructores


    public Estudiante() {
    }

    public Estudiante(String codigo, String nombre, float promedio, Carrera carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
        Carrera = carrera;
    }

    public boolean aprobar() {
        if (promedio >= 70) {
            return true;  // Devuelve verdadero si es mayor o igual a 70
        } else {
            return false; // Devuelve falso si es menor
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera carrera) {
        Carrera = carrera;
    }

    @Override
    public String toString() {
        // Usamos un if simple para el estado
        String estado;
        if (this.promedio >= 70) {
            estado = "Aprobado";
        } else {
            estado = "Reprobado";
        }

        return "Nombre: " + nombre + " | Promedio: " + promedio + " | Carrera: " + Carrera.getNombre() + " | Estado: " + estado;
    }
}


