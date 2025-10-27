package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.model.TipoReporte;
import utp.com.pe.utp.repository.TipoReporteRepository;
import utp.com.pe.utp.service.TipoReporteInterface;

import java.util.List;

@Service
public class TipoReporteInterfaceImpl implements TipoReporteInterface {

    @Autowired
    private TipoReporteRepository tipoRepo;

    @Override
    public TipoReporte crearTipo(TipoReporte tipo) {
        return tipoRepo.save(tipo);
    }

    @Override
    public List<TipoReporte> listarTipos() {
        return tipoRepo.findAll();
    }
}