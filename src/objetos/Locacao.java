/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.time.LocalDateTime;

/**
 *
 * @author rodolfobrandao
 */
public class Locacao {

    public int id;
    public int id_carro;
    public int id_seguradora;
    public int id_cliente;
    public LocalDateTime dataLocacao;
    public LocalDateTime dataDevolucao;
    public LocalDateTime dataDevolvida;
    public Double valor;
    public Double valorDesconto;
    public Double valorTotal;

}
