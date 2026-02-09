/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
//        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
//        repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
//        repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));
//        String nomeFixoArquivoFisica = "PessoasFisica.bin";
//        try {
//            repo1.persistir(nomeFixoArquivoFisica);
//        } catch (IOException e) {
//            System.out.println("Erro grave: Não consegui salvar no disco!");
//            e.printStackTrace();
//        }
//        
//        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
//        try {
//            repo2.recuperar(nomeFixoArquivoFisica);
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Erro ao carregar dados: " + e.getMessage());
//        }
//        //Exibir dados recuperados
//        ArrayList<PessoaFisica> listPessoaFisica = repo2.obterTodos();
//        for (PessoaFisica pessoa : listPessoaFisica) {
//            pessoa.exibir();
//        }
//        
//        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
//        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
//        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));
//        String nomeFixoArquivoJuridica = "PessoasJuridica.bin";
//        try {
//            repo3.persistir(nomeFixoArquivoJuridica);
//        } catch (IOException e) {
//            System.out.println("Erro grave: Não consegui salvar no disco!");
//            e.printStackTrace();
//        }
//        
//        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
//        try {
//            repo4.recuperar(nomeFixoArquivoJuridica);
//        }  catch (IOException | ClassNotFoundException e) {
//            System.out.println("Erro ao carregar dados: " + e.getMessage());
//        }
//        //Exibir dados recuperados
//        ArrayList<PessoaJuridica> listPessoaJuridica = repo4.obterTodos();
//        for (PessoaJuridica pessoa : listPessoaJuridica) {
//            pessoa.exibir();
//        }
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo id");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Registrar dados");
            System.out.println("7 - Recuper dados");
            System.out.println("0 - Finalizar programa");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char opcaoCase1 = scanner.next().toUpperCase().charAt(0);

                    switch (opcaoCase1) {
                        case 'F':
                            System.out.println("Digite o id da pessoa");
                            int idFisica = scanner.nextInt();
                            System.out.println("Digite o nome:");
                            scanner.nextLine();
                            String nomeFisica = scanner.nextLine();
                            System.out.println("Digite o CPF:");
                            String cpfFisica = scanner.nextLine();
                            System.out.println("Digite a idade:");
                            int idadeFisica = scanner.nextInt();
                            pessoaFisicaRepo.inserir(new PessoaFisica(idFisica, nomeFisica, cpfFisica, idadeFisica));
                            break;
                        case 'J':
                            System.out.println("Digite o id da pessoa");
                            int idJuridica = scanner.nextInt();
                            System.out.println("Digite o nome:");
                            scanner.nextLine();
                            String nomeJuridica = scanner.nextLine();
                            System.out.println("Digite o CNPJ:");
                            String cnpjJuridica = scanner.nextLine();
                            pessoaJuridicaRepo.inserir(new PessoaJuridica(idJuridica, nomeJuridica, cnpjJuridica));
                            break;
                        default:
                            System.out.println("Opção inválida! Digite F ou J.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char opcaoCase2 = scanner.next().toUpperCase().charAt(0);

                    switch (opcaoCase2) {
                        case 'F':
                            System.out.println("Informe o id da pessoa que deseja alterar");
                            int idObterFisica = scanner.nextInt();
                            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(idObterFisica);
                            pessoaFisica.exibir();
                            System.out.println("Digite o id da pessoa");
                            int idFisica = scanner.nextInt();
                            System.out.println("Digite o nome:");
                            scanner.nextLine();
                            String nomeFisica = scanner.nextLine();
                            System.out.println("Digite o CPF:");
                            String cpfFisica = scanner.nextLine();
                            System.out.println("Digite a idade:");
                            int idadeFisica = scanner.nextInt();
                            pessoaFisicaRepo.alterar(new PessoaFisica(idFisica, nomeFisica, cpfFisica, idadeFisica));
                            break;
                        case 'J':
                            System.out.println("Informe o id da pessoa que deseja alterar");
                            int idObterJuridica = scanner.nextInt();
                            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(idObterJuridica);
                            pessoaJuridica.exibir();
                            System.out.println("Digite o id da pessoa");
                            int idJuridica = scanner.nextInt();
                            System.out.println("Digite o nome:");
                            scanner.nextLine();
                            String nomeJuridica = scanner.nextLine();
                            System.out.println("Digite o CNPJ:");
                            String cnpjJuridica = scanner.nextLine();
                            pessoaJuridicaRepo.alterar(new PessoaJuridica(idJuridica, nomeJuridica, cnpjJuridica));
                            break;
                        default:
                            System.out.println("Opção inválida! Digite F ou J.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char opcaoCase3 = scanner.next().toUpperCase().charAt(0);

                    switch (opcaoCase3) {
                        case 'F':
                            System.out.println("Informe o id da pessoa que deseja excluir");
                            int idExcluirFisica = scanner.nextInt();
                            pessoaFisicaRepo.excluir(idExcluirFisica);
                            System.out.println("Sucesso");
                            break;
                        case 'J':
                            System.out.println("Informe o id da pessoa que deseja excluir");
                            int idExcluirJuridica = scanner.nextInt();
                            pessoaJuridicaRepo.excluir(idExcluirJuridica);
                            System.out.println("Sucesso");
                            break;
                        default:
                            System.out.println("Opção inválida! Digite F ou J.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char opcaoCase4 = scanner.next().toUpperCase().charAt(0);

                    switch (opcaoCase4) {
                        case 'F':
                            System.out.println("Informe o id da pessoa que deseja obter os dados");
                            int idObterPFisica = scanner.nextInt();
                            PessoaFisica pf = pessoaFisicaRepo.obter(idObterPFisica);
                            pf.exibir();
                            break;
                        case 'J':
                            System.out.println("Informe o id da pessoa que deseja obter os dados");
                            int idObterPJuridica = scanner.nextInt();
                            PessoaJuridica pj = pessoaJuridicaRepo.obter(idObterPJuridica);
                            pj.exibir();
                            break;
                        default:
                            System.out.println("Opção inválida! Digite F ou J.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char opcaoCase5 = scanner.next().toUpperCase().charAt(0);
                    
                    switch (opcaoCase5) {
                        case 'F':
                            ArrayList<PessoaFisica> pessoasFisica = pessoaFisicaRepo.obterTodos();
                            for (PessoaFisica pessoa : pessoasFisica) {
                                pessoa.exibir();
                            }
                            break;
                        case 'J':
                            ArrayList<PessoaJuridica> pessoasJuridica = pessoaJuridicaRepo.obterTodos();
                            for (PessoaJuridica pessoa : pessoasJuridica) {
                                pessoa.exibir();
                            }
                            break;
                        default:
                            System.out.println("Opção inválida! Digite F ou J.");
                            break;    
                    }
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Digite o prefixo dos arquivos");
                    String caminhoArquivoPersistir = scanner.nextLine();
                    try {
                        pessoaFisicaRepo.persistir(caminhoArquivoPersistir + "fisica.bin");
                        pessoaJuridicaRepo.persistir(caminhoArquivoPersistir + "juridica.bin");
                    } catch (IOException e) {
                        System.out.println("Erro grave: Não consegui salvar no disco!");
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("Digite o prefixo dos arquivos");
                    String caminhoArquivoRecuperar = scanner.nextLine();
                    try {
                        pessoaFisicaRepo.recuperar(caminhoArquivoRecuperar + "fisica.bin");
                        pessoaJuridicaRepo.recuperar(caminhoArquivoRecuperar + "juridica.bin");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao carregar dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Finalizando o sistema...");
                    break;    
                default:
                    System.out.println("\nOpção inválida!");
                    System.out.println("Por favor, digite um número entre 0 e 7.");
                    break;    
            }
        } while (opcao != 0);

    }

}
