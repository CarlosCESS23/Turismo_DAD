package servidor.service;

import model.Hotel;
import seguro.model.SeguroViagem;
import servidor.excecoes.DuplicationIDException;
import servidor.helper.HotelServiceHelper;
import servidor.helper.SeguroServiceHelper;
import servidor.model.Item;
import servidor.model.Pacote;
import servidor.utils.ItemServico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacoteService  extends UnicastRemoteObject implements IPacoteService{
    private final HotelServiceHelper hotelServiceHelper = new HotelServiceHelper();
    private final SeguroServiceHelper seguroServiceHelper = new SeguroServiceHelper();

    private List<Pacote> pacotes;

    public PacoteService() throws RemoteException {
        pacotes = new ArrayList<Pacote>();
        pacotes.add(new Pacote(1, "Manaus", "Pará", 2));
        pacotes.add(new Pacote(2, "Belém", "Boa Vista", 1));
        pacotes.add(new Pacote(3, "Macapá", "Palmas", 4));
        pacotes.add(new Pacote(4, "Porto Velho", "Belém", 3));
        pacotes.add(new Pacote(5, "Manaus", "Macapá", 2));
        pacotes.add(new Pacote(6, "Boa Vista", "Porto Velho", 5));
        pacotes.add(new Pacote(7, "Palmas", "Belém", 2));
        pacotes.add(new Pacote(8, "Belém", "Pará", 3));
    }

    public Pacote montarPacote(String origem, String destino,int id,int quantPessoa) throws RemoteException {
        try{
            //Verificando se o pacote está vazio
            if(!pacotes.isEmpty()){
                // Variavel optional para verificar se existe a duplicação de ID
                Optional<Pacote> verificarIDPacote = pacotes.stream().filter(p -> p.getIdPacote() == id).findFirst();

                // Caso realmente ele encontre, ele entrará nessa exceção informando o erro
                if ((verificarIDPacote.isPresent())) {
                    throw new DuplicationIDException("Não foi possível montar o pacote, pois conflita com ID existente: " +  verificarIDPacote.get().getIdPacote());
                }
            }
        }catch (DuplicationIDException e){
                System.out.println(e);
                return null;
            }
            // Caso não, ele simplesmente efetuará a montagem

            Hotel hotel = (Hotel) hotelServiceHelper.consultarHotel(destino);
            SeguroViagem seguroViagem = (SeguroViagem) seguroServiceHelper.consultarSeguroViagem(destino);

            Item item1 = new Item(hotel.getValorDiaria(), ItemServico.HOTEL);
            Item item2 = new Item(seguroViagem.getDiaria(), ItemServico.SEGURO);

            Pacote pacote = new Pacote(id, origem, destino, quantPessoa);

            pacote.adicionarItem(item1);
            pacote.adicionarItem(item2);

            return pacote;
    }

    @Override
    public List<Item> buscarTipo(ItemServico tipo) throws RemoteException  {
        return null;
    }

    public Pacote buscarPacote(String origem, String destino) throws RemoteException {
//        return montarPacote();
        return null;
    }

    public List<Pacote> listarPacote() throws RemoteException {
        return this.pacotes;
    }

    public void addPacote(Pacote pacote) throws RemoteException {
        if(!(pacote == null)){
            pacotes.add(pacote);
        }
        return;

    }
    public void rmPacote(Pacote pacote) throws RemoteException {

    }

    @Override
    public List<Item> buscarPorOrigemDestino(String origem, String destino) throws RemoteException {
        return null;
    }
}
