package utp.com.pe.utp.service;

import utp.com.pe.utp.model.TipoEquipo;

import java.util.List;

public interface TipoEquipoInterface {
    TipoEquipo crearTipoEquipo(TipoEquipo tipo);
    List<TipoEquipo> listarTipos();
}