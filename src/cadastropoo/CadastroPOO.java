/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import java.util.ArrayList;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Felipe
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
        repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));
        String nomeFixoArquivoFisica = "PessoasFisica.bin";
        try {
            repo1.persistir(nomeFixoArquivoFisica);
        } catch (IOException e) {
            System.out.println("Erro grave: Não consegui salvar no disco!");
            e.printStackTrace();
        }
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar(nomeFixoArquivoFisica);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
        //Exibir dados recuperados
        ArrayList<PessoaFisica> listPessoaFisica = repo2.obterTodos();
        for (PessoaFisica pessoa : listPessoaFisica) {
            pessoa.exibir();
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));
        String nomeFixoArquivoJuridica = "PessoasJuridica.bin";
        try {
            repo3.persistir(nomeFixoArquivoJuridica);
        } catch (IOException e) {
            System.out.println("Erro grave: Não consegui salvar no disco!");
            e.printStackTrace();
        }
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar(nomeFixoArquivoJuridica);
        }  catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
        //Exibir dados recuperados
        ArrayList<PessoaJuridica> listPessoaJuridica = repo4.obterTodos();
        for (PessoaJuridica pessoa : listPessoaJuridica) {
            pessoa.exibir();
        }
    }
    
}
