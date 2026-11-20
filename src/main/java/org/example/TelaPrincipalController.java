package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaPrincipalController{
    /*Topo*/
    @FXML private ComboBox<String> cbMes;

    /*Itens fixos*/
    @FXML private Label lblTotalFixos;
    @FXML private TextField tfDescricaoFixo;
    @FXML private TextField tfDiaFixo;
    @FXML private TextField tfValorFixo;

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
