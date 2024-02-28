/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.demo.service.impl;

import practica1.demo.dao.ArbolDao;
import practica1.demo.domain.Arbol;
import practica1.demo.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alejh
 */
@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArbol(boolean activos) {
        var lista = arbolDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    @Override
    @Transactional
    public void guardarArbol(Arbol arbol) {
        arbolDao.save(arbol);
    }
    @Override
    @Transactional
    public void eliminarArbol(Arbol arbol) {
        arbolDao.delete(arbol);
    }
    @Override
    @Transactional
    public void modificarArbol(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional(readOnly = true)
    public Arbol obtenerArbolPorId(Long id) {
        return arbolDao.findById(id).orElse(null);
    }
}

