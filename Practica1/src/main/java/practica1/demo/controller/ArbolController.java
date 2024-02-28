/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practica1.demo.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practica1.demo.domain.Arbol;

@Controller
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/")
    public String index(Model model) {
        var arboles = arbolService.getArbol(false);
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "index";
    }

    @PostMapping("/arbol/guardar")
    public String guardarArbol(@ModelAttribute Arbol arbol) {
        arbolService.guardarArbol(arbol);
        return "redirect:/"; // Esto debería redirigir a la vista "index.html"
    }

    @GetMapping("/arbol/eliminar/{id}")
    public String eliminarArbol(@PathVariable Long id) {
        Arbol arbol = arbolService.obtenerArbolPorId(id);
        if (arbol != null) {
            arbolService.eliminarArbol(arbol);
        }
        return "redirect:/"; // Redirige al listado de árboles después de eliminar uno
    }

    @GetMapping("/arbol/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable Long id, Model model) {
        Arbol arbol = arbolService.obtenerArbolPorId(id);
        model.addAttribute("arbol", arbol);
        return "arbol/fragmentos :: editarArbol";
    }

    @PostMapping("/arbol/modificar/{id}")
    public String modificarArbol(@PathVariable Long id, @ModelAttribute Arbol arbol) {
    // Realiza la lógica para modificar el árbol con el ID proporcionado
        arbolService.guardarArbol(arbol);
        return "redirect:/"; // Redirige al listado de árboles después de la modificación
    }
}
