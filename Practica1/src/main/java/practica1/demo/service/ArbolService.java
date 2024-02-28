/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.demo.service;

import practica1.demo.domain.Arbol;
import java.util.List;

public interface ArbolService {    
    // Se obtiene un listado de categorias en un List   
    public List<Arbol> getArbol(boolean activos); 
     public void guardarArbol(Arbol arbol);
     public void eliminarArbol(Arbol arbol);
     public Arbol obtenerArbolPorId(Long id);
     public void modificarArbol(Arbol arbol);
}
    