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
public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> listPessoaFisica = new ArrayList<>();
    
    public void inserir(PessoaFisica pessoaFisica) {
        listPessoaFisica.add(pessoaFisica);
    }
    
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < listPessoaFisica.size(); i++) {
            PessoaFisica p = listPessoaFisica.get(i);
            
            if (p.getId() == pessoaFisica.getId()) {
                listPessoaFisica.set(i, pessoaFisica);
                return;
            }
        }
    }
    
    public void excluir(int id) {
        for (int i = 0; i < listPessoaFisica.size(); i++) {
            PessoaFisica p = listPessoaFisica.get(i);
            
            if(p.getId() == id) {
                listPessoaFisica.remove(i);
                break;
            }
        }
    }
    public PessoaFisica obter(int id) {
        for (PessoaFisica p : listPessoaFisica){
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public ArrayList<PessoaFisica> obterTodos() {
        return listPessoaFisica;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            
            objectOut.writeObject(listPessoaFisica);
            System.out.println("Dados de Pessoa Fisica armazenados.");
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        File arquivo = new File(nomeArquivo);
        
        if(!arquivo.exists()) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
            return;
        }
        
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            this.listPessoaFisica = (ArrayList<PessoaFisica>) objectIn.readObject();
            System.out.println("Dados de Pessoa Fisica recuperados.");
        }
    }
}
