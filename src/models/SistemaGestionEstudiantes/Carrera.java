package models.SistemaGestionEstudiantes;

public class Carrera {
    //Atributos
    private String nombre;
    private int duracion;

    //Constructores
    public Carrera() {
    }

    public Carrera(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    //Getter and Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //toString

    @Override
    public String toString() {
        return "Carrera{" +
                "nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
