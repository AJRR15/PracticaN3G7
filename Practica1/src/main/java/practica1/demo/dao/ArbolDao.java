/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.demo.dao;
import java.util.List;
import practica1.demo.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alejh
 */
public interface ArbolDao extends JpaRepository <Arbol,Long> {
    List<Arbol> findByActivoTrue();
}
