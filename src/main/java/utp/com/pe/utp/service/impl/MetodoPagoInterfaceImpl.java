package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.model.MetodoPago;
import utp.com.pe.utp.repository.MetodoPagoRepository;
import utp.com.pe.utp.service.MetodoPagoInterface;

import java.util.List;

@Service
public class MetodoPagoInterfaceImpl implements MetodoPagoInterface {

    @Autowired
    private MetodoPagoRepository metodoRepo;

    @Override
    public MetodoPago crearMetodo(MetodoPago metodo) {
        return metodoRepo.save(metodo);
    }

    @Override
    public List<MetodoPago> listarMetodos() {
        return metodoRepo.findAll();
    }
}