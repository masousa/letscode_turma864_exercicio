package tech.ada.oitomeiaquatro.servico;

import tech.ada.oitomeiaquatro.dominio.Agendamento;
import tech.ada.oitomeiaquatro.dominio.Cliente;
import tech.ada.oitomeiaquatro.excecoes.AcabouASenhaExcecao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agendar {
    private List<Agendamento> agendamentos;
    public Agendar(){
        agendamentos = new ArrayList<>();
    }

    public Agendamento realizarAgendamento(Cliente cliente) throws AcabouASenhaExcecao{
        LocalDateTime horarioAtendimento = pegarProximoHorarioAtendimento();

        Agendamento novoAgendamento = new Agendamento(cliente,
                    DateTimeFormatter.ofPattern("yyyyMMddHHmm").format(horarioAtendimento), horarioAtendimento);
        agendamentos.add(novoAgendamento);
        return novoAgendamento;


    }

    public String imprimirAgenda(){
        Iterator<Agendamento> iterator = agendamentos.iterator();

        StringBuilder builder = new StringBuilder();

        String saida = "";
        if(iterator.hasNext()){

            //saida = "Dia do atendimento "+DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now());
            builder.append("Dia do atendimento "+DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));
            //saida=saida+ "\nIdentificador Agendamento \t Nome do cliente \t Horário Agendamento";
            builder.append("\nIdentificador Agendamento \t Nome do cliente \t Horário Agendamento");


            while(iterator.hasNext()) {
                Agendamento proximoAgendamento = iterator.next();
                //saida += "\n";
                builder.append("\n");
                //saida = saida + proximoAgendamento.getIdentificador() + "\t" + proximoAgendamento.getCliente().getNome() + "\t" + DateTimeFormatter.ofPattern("HH:mm").format(proximoAgendamento.getHorario());
                builder.append(saida + proximoAgendamento.getIdentificador() + "\t" + proximoAgendamento.getCliente().getNome() + "\t"
                        + DateTimeFormatter.ofPattern("HH:mm").format(proximoAgendamento.getHorario()));
            }
        }


        return builder.toString();

    }
    private LocalDateTime pegarProximoHorarioAtendimento() throws AcabouASenhaExcecao{

        LocalDateTime localDateTime=null;
        // Só permite 32 senhas por dia
        if(agendamentos.size()==32){
            throw new AcabouASenhaExcecao();
        }
        // Está vazia

        if(agendamentos.isEmpty()){

            localDateTime = LocalDate.now().atTime(8,0);
        }else{
            Agendamento ultimoAgendamento = agendamentos.get(agendamentos.size()-1);
            localDateTime = ultimoAgendamento.getHorario().plusMinutes(15);
        }

        return localDateTime;
    }

    private void imprimirUltimoAgendamento(){
        agendamentos.size();
    }
}
