/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;
    private String rutaImagen;
    private String nombreComun;
    private String tipoFlor;
    private String durezaMadera;
    private String otrosDetalles;
    private boolean activo;
    
    public Arbol() {
    }

    public Arbol(String rutaImagen, String nombreComun, String tipoFlor, String durezaMadera, String otrosDetalles, boolean activo) {
        this.rutaImagen = rutaImagen;
        this.nombreComun = nombreComun;
        this.tipoFlor = tipoFlor;
        this.durezaMadera = durezaMadera;
        this.otrosDetalles = otrosDetalles;
        this.activo = activo;
    }

}



