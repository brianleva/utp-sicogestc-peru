package utp.com.pe.utp.service;

import utp.com.pe.utp.model.Estado;

import java.util.List;

public interface EstadoInterface {
    Estado crearEstado(Estado estado);
    Estado actualizarEstado(Integer id, Estado estado);
    List<Estado> listarEstados();
}