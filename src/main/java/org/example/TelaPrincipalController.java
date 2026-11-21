package org.example;
import org.example.ItemFixo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.awt.event.ActionEvent;

public class TelaPrincipalController{
    /*Topo*/
    @FXML private ComboBox<String> cbMes;

    /*Itens fixos*/
    @FXML private Label lblTotalFixos;
    @FXML private TextField tfDescricaoFixo;
    @FXML private TextField tfDiaFixo;
    @FXML private TextField tfValorFixo;
    /*@FXML
    private void adicionarFixo(ActionEvent event){
        String descricao = tfDescricaoFixo.getText();
        int dia = Integer.parseInt(tfDiaFixo.getText());
        double valor = Double.parseDouble(tfValorFixo.getText());
        ItemFixo fixo = new ItemFixo(descricao, dia, valor);
    }*/

    /*Entradas e saídas*/
    @FXML private Label lblTotalES;
    @FXML private Label lblSaldo;
    @FXML private TextField tfDescricaoES;
    @FXML private ComboBox<String> cbTipoES;
    @FXML private TextField tfValorES;

    /*Gastos do mês*/
    @FXML private Label lblTotalGastos;
    @FXML private TextField tfDescricao;
    @FXML private DatePicker dpData;
    @FXML private ComboBox<String> cbCategoria;
    @FXML private TextField tfValor;
}
