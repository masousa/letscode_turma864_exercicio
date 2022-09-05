package tech.ada.oitomeiaquatro;


import tech.ada.oitomeiaquatro.dominio.Agendamento;
import tech.ada.oitomeiaquatro.dominio.Cliente;
import tech.ada.oitomeiaquatro.excecoes.AcabouASenhaExcecao;
import tech.ada.oitomeiaquatro.servico.Agendar;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Agendar agendar = new Agendar();
        System.out.println("Bem vindo ao sistema de agendamento");
        Integer opcao =0;
        do {
            System.out.println("Seleciona a opção desejada");
            System.out.println(" 1 - Realizar agendamento \n 2 - Listar Agendamentos do dia");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:

                    Cliente cliente = new Cliente();
                    System.out.println("informe o cpf");
                    cliente.setCpf(scanner.next());
                    System.out.println("informe o nome");
                    cliente.setNome(scanner.next());


                    try {
                        Agendamento agendamento = agendar.realizarAgendamento(cliente);
                        System.out.printf("Agendamento realizado com sucesso %n Agendamento: %s em: %s ",
                               agendamento.getIdentificador() ,DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")
                                        .format(agendamento.getHorario()));
                    } catch (AcabouASenhaExcecao e) {
                        System.err.println(e.getMessage());

                        e.printStackTrace();
                    }

                    break;
                case 2:
                    // TODO listar agendamentos
                    System.out.println(agendar.imprimirAgenda());
                    break;
                default:
                    System.out.println("Informação inválida");

            }
        }while (opcao!=0);

    }
}
