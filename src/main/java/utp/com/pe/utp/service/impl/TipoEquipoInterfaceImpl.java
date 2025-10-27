package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import utp.com.pe.utp.model.TipoEquipo;
import utp.com.pe.utp.repository.TipoEquipoRepository;
import utp.com.pe.utp.service.TipoEquipoInterface;

import java.util.List;

public class TipoEquipoInterfaceImpl implements TipoEquipoInterface {

    @Autowired
    private TipoEquipoRepository tipoRepo;

    @Override
    public TipoEquipo crearTipoEquipo(TipoEquipo tipo) {
        return tipoRepo.save(tipo);
    }

    @Override
    public List<TipoEquipo> listarTipos() {
        return tipoRepo.findAll();
    }

}