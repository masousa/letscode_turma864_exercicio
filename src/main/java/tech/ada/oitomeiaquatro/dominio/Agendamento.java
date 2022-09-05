package tech.ada.oitomeiaquatro.dominio;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Agendamento {
    private Cliente cliente;
    private String identificador;
    private LocalDateTime horario;

   public Agendamento(Cliente cliente, String identificador){

   }

    public Agendamento(Cliente jose, String identificador, LocalDateTime horario) {
        this.cliente = jose;
        this.identificador = identificador;
        this.horario = horario;
    }

    public void nomeMethod(){}

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

    }

    public void setIdentificador(String novoValor) {
        this.identificador = novoValor;
    }
}
