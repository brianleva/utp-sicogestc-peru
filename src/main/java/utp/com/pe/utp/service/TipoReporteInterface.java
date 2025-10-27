package utp.com.pe.utp.service;

import utp.com.pe.utp.model.TipoReporte;

import java.util.List;

public interface TipoReporteInterface {
    TipoReporte crearTipo(TipoReporte tipo);
    List<TipoReporte> listarTipos();
}