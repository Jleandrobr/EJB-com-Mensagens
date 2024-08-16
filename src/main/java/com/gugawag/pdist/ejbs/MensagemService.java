package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDao;

    @EJB
    private UsuarioDAO usuarioDao;

    public List<Mensagem> listar(){
        return mensagemDao.listar();
    }

    public void inserir(long id, String mensagem){
        Mensagem novaMensagem = new Mensagem(id, mensagem);
        mensagemDao.inserir(novaMensagem);

        if (mensagem.contains("palavrao")) {
            throw new RuntimeException("Palavrao nao sao permitidos!");
        }
        if (id == 4L) {
            novaMensagem.setMensagem(mensagem + " alterado");
        }
    }
    
}
