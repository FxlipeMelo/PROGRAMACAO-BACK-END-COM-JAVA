package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> listPessoaJuridica = new ArrayList<>();
    
    public void inserir(PessoaJuridica pessoaJuridica) {
        listPessoaJuridica.add(pessoaJuridica);
    }
    
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < listPessoaJuridica.size(); i++) {
            PessoaJuridica p = listPessoaJuridica.get(i);
            
            if (p.getId() == pessoaJuridica.getId()) {
                listPessoaJuridica.set(i, pessoaJuridica);
                return;
            }
        }
    }
    
    public void excluir(int id) {
        for (int i = 0; i < listPessoaJuridica.size(); i++) {
            PessoaJuridica p = listPessoaJuridica.get(i);
            
            if (p.getId() == id){
                listPessoaJuridica.remove(i);
                break;
            }
        }
    }
    
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica p : listPessoaJuridica) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public ArrayList<PessoaJuridica> obterTodos() {
        return listPessoaJuridica;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(listPessoaJuridica);
            System.out.println("Dados de Pessoa Juridica armazenados.");
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        File arquivo = new File(nomeArquivo);
        
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
            return;
        }
        
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            this.listPessoaJuridica = (ArrayList<PessoaJuridica>) objectIn.readObject();
            System.out.println("Dados de Pessoa Juridica recuperados.");
        }
            
    }
}
