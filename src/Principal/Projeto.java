import Classes.*;
import Classes.Avaliacao;
import Classes.AvaliacaoRepository;
import Classes.AreaVerde;
import Classes.AreaVerdeRepository;

import java.util.List;
import java.util.Scanner;


public class Projeto {

    public static void main(String[] args) {
      LocalizacaoRepository localizacaoRepository = new LocalizacaoRepository();
      AvaliacaoRepository avaliacaoRepository = new AvaliacaoRepository();
      AreaVerdeRepository areaVerdeRepository = new AreaVerdeRepository();


     System.out.println("Bem vindo!");
     Scanner entrada = new Scanner(System.in);

     int menu;

     do {
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Cadastrar uma nova Área Verde");
      System.out.println("2 - Avaliar Área Verde");
      System.out.println("3 - Exibir detalhes de uma Área Verde");
      System.out.println("4 - Listar Áreas Verdes");
      System.out.println("0 - Sair");

      menu = Integer.parseInt(entrada.nextLine());

      switch (menu) {
       case 1 -> menuCadastrar(entrada, areaVerdeRepository, localizacaoRepository);
       case 2 -> menuAvaliar(entrada, avaliacaoRepository, areaVerdeRepository);
       case 3 -> menuDetalhe(entrada, areaVerdeRepository);
       case 4 -> menuListar(entrada, areaVerdeRepository);
       case 0 -> System.out.println("Encerrando sessão.");
       default -> System.out.println("Selecione uma opção válida.");
      }
     } while (menu != 0);
    }


    private static void menuCadastrar(Scanner entrada, AreaVerdeRepository areaVerdeRepository, LocalizacaoRepository localizacaoRepository) {
       System.out.println("Digite um nome para a Área Verde: ");
       String nomeAreaVerde = entrada.nextLine();
       System.out.println("Digite as coordenadas: ");
       String coordenadasAreaVerde = entrada.nextLine();
       System.out.println("Digite o tipo de vegetação: ");
       String vegetacaoAreaVerde = entrada.nextLine();
       System.out.println("Atividades disponíveis: ");
       String atividadesAreaVerde = entrada.nextLine();
       System.out.println("Horário de funcionamento: ");
       String horarioAreaVerde = entrada.nextLine();
       Localizacao localizacao = new Localizacao();
       localizacao.setCoordenadas(coordenadasAreaVerde);
       localizacao.setIdentificador("Área Verde " + (localizacaoRepository.getLocalizacoes().size() + 1));
       localizacaoRepository.adicionarLocalizacao(localizacao);
       AreaVerde novaArea = new AreaVerde(nomeAreaVerde, coordenadasAreaVerde, vegetacaoAreaVerde, atividadesAreaVerde, horarioAreaVerde, localizacao);
       AreaVerdeRepository.adicionarAreaVerde(novaArea);
       System.out.println("Área verde cadastrada com sucesso!");
    }

    private static void menuAvaliar(Scanner entrada, AvaliacaoRepository avaliacaoRepository, AreaVerdeRepository areaVerdeRepository) {
     Avaliacao avaliacao = new Avaliacao();
     System.out.println("Digite o ID da área verde a ser avaliada:");
     String idAv = entrada.nextLine();
     AreaVerde avaliacaoAreaVerde = areaVerdeRepository.buscarPorId(idAv);

     if (avaliacaoAreaVerde != null) {
         if (avaliacaoAreaVerde.getAvaliacoes().isEmpty()){
             System.out.println("Digite uma nota de 0 a 5 para a vegetação: ");
             double quantidadeArvores = entrada.nextDouble();
             System.out.println("Digite uma nota de 0 a 5 nota para a qualidade do ar: ");
             double qualidadeDoAr = entrada.nextDouble();
             System.out.println("Digite uma nota de 0 a 5 nota para a poluição sonora: ");
             double poluicaoSonora = entrada.nextDouble();
             System.out.println("Digite uma nota de 0 a 5 nota para a coleta de resíduos: ");
             double coletaResiduos = entrada.nextDouble();
             System.out.println("Digite uma nota de 0 a 5 nota para acesso com transporte a Área Verde: ");
             double transporte = entrada.nextDouble();
             entrada.nextLine();
             Localizacao localizacao = new Localizacao();

             Avaliacao novaAv = new Avaliacao(quantidadeArvores, qualidadeDoAr, poluicaoSonora, coletaResiduos, transporte);
             AvaliacaoRepository.adicionarAvaliacao(novaAv);
             avaliacaoAreaVerde.adicionarAvaliacao(novaAv);
             System.out.println("Avaliação cadastrada com sucesso!");
             System.out.println("A média das notas é: " + novaAv.getMedia());
         } else {
             System.out.println("Área Verde já avaliada!");
         }

     } else {
         System.out.println("Área Verde não encontrada!");
     }
    }

    private static  void menuDetalhe(Scanner entrada, AreaVerdeRepository areaVerdeRepository) {
     AreaVerde areaVerde = new AreaVerde();
     System.out.println("Digite o ID da área verde para ver os detalhes: ");
     String idDetalhes = entrada.nextLine();
     AreaVerde detalhesAv = areaVerdeRepository.buscarPorId(idDetalhes);
     if (detalhesAv != null) {
      System.out.println("Detalhes da Área Verde: ");
      System.out.println(detalhesAv);
      for (Avaliacao avaliacao : detalhesAv.getAvaliacoes())
          System.out.println(avaliacao);
     } else {
      System.out.println("Área Verde não encontrada");
     }
    }

     private static void menuListar(Scanner entrada, AreaVerdeRepository areaVerdeRepository) {
      System.out.println("Área Verdes cadastradas:");
      List<AreaVerde> areasVerdes = areaVerdeRepository.listarAreasVerdes();
      if (areasVerdes.isEmpty()){
          System.out.println("Nenhuma Área Verde cadastrada.");
      }
      else {
          for (AreaVerde areaVerde : areasVerdes) {
              System.out.println("ID: " + areaVerde.getIdAreaVerde());
              System.out.println("Nome: " + areaVerde.getNomeAreaVerde());
              System.out.println("Tipo de vegetação: " + areaVerde.getVegetacaoAreaVerde());
              System.out.println("Média das avaliações: " + areaVerde.getMediaAvaliacoes());
              System.out.println("--------------------");
          }
      }
      }
}



