package seguro.service;


import seguro.ISeguroViagemService;
import seguro.model.SeguroViagem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

//Implementação RMI do serviço de Seguro Viagem.
public class SeguroViagemServiceImpl extends UnicastRemoteObject implements ISeguroViagemService {

    private SeguroViagemService service;

    public SeguroViagemServiceImpl() throws RemoteException{


        super(2002);

        service = new SeguroViagemService();

    }

    @Override
    public List<SeguroViagem> listar() throws RemoteException {
        return service.listar();
    }

    @Override
    public SeguroViagem buscarPorEstado(String estado) throws RemoteException {
        return service.buscarPorEstado(estado);
    }
}
