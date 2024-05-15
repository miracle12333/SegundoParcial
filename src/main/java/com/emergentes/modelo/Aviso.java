
package com.emergentes.modelo;


public class Aviso {
    private int id;
    private String nombres;
    private String apellidos;
    private String seminario;
    private String fecha_inscripcion;

    public Aviso() {
           id = 0;
        nombres = "";
        apellidos = "";
        seminario = "";
        fecha_inscripcion="";
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }
    
    
    
}

 