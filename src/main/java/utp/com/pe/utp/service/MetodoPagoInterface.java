package utp.com.pe.utp.service;

import utp.com.pe.utp.model.MetodoPago;

import java.util.List;

public interface MetodoPagoInterface {
    MetodoPago crearMetodo(MetodoPago metodo);
    List<MetodoPago> listarMetodos();
}