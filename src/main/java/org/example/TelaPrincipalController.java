package org.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TelaPrincipalController{
    /*Topo*/
    @FXML private ComboBox<String> cbMes;

    /*Itens fixos*/
    @FXML private Label lblTotalFixos;
    @FXML private TextField tfDescricaoFixo;
    @FXML private TextField tfDiaFixo;
    @FXML private TextField tfValorFixo;
    @FXML private TableView<ItemFixo> tabelaFixos;
    @FXML private TableColumn<ItemFixo, String> colItem;
    @FXML private TableColumn<ItemFixo, String> colDia;
    @FXML private TableColumn<ItemFixo, String> colValor;
    @FXML private TableColumn<ItemFixo, Boolean> colPago;

    /*Entradas e saídas*/
    @FXML private Label lblTotalES;
    @FXML private Label lblSaldo;
    @FXML private TextField tfDescricaoES;
    @FXML private ComboBox<String> cbTipoES;
    @FXML private TextField tfValorES;
    @FXML private TableView<EntradaSaida> tabelaEntradasSaidas;
    @FXML private TableColumn<EntradaSaida, String> colDescricaoES;
    @FXML private TableColumn<EntradaSaida, String> colTipoES;
    @FXML private TableColumn<EntradaSaida, String> colValorES;

    /*Gastos do mês*/
    @FXML private Label lblTotalGastos;
    @FXML private TextField tfDescricao;
    @FXML private DatePicker dpData;
    @FXML private ComboBox<String> cbCategoria;
    @FXML private TextField tfValor;
    @FXML private TableView<Gasto> tabelaGastos;
    @FXML private TableColumn<Gasto, String> colDescricaoG;
    @FXML private TableColumn<Gasto, String> colDataG;
    @FXML private TableColumn<Gasto, String> colCategoriaG;
    @FXML private TableColumn<Gasto, String> colValorG;


        /*Listas*/
        private final ObservableList<ItemFixo> listaFixos = FXCollections.observableArrayList();
        private final ObservableList<EntradaSaida> listaES = FXCollections.observableArrayList();
        private final ObservableList<Gasto> listaGastos = FXCollections.observableArrayList();

        /*Formato*/
        private final NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM");

        private String formatarMoeda(double valor){
            return formatoMoeda.format(valor);
        }

        /*Para que a planilha consiga rodar sozinha*/
        @FXML
        public void initialize(){
            preencherListas();
            ligarTabelaFixos();
            ligarTabelaEntradasSaidas();
            ligarTabelaGastos();
        }
        private void preencherListas(){
            cbMes.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                    "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");

            cbMes.getSelectionModel().select(LocalDate.now().getMonthValue() - 1);

            cbTipoES.getItems().addAll("Salário", "Extra"); /*Aqui podemos adicionar daquela forma que você queria, salário e extra. Já adicionei :)*/

            cbCategoria.getItems().addAll("Mercado", "Transporte", "Restaurante", "Lazer", "Estudos", "Presentes", "Outros");
        }

        private void ligarTabelaFixos(){
            tabelaFixos.setItems(listaFixos);
            tabelaFixos.setEditable(true);

            /*Caixinha do check, ainda não tenho total certeza se esta funcionando, precisamos adicionar os itens na tabela. Qualquer coisa eu arrumo depois*/
            colPago.setCellValueFactory(c -> c.getValue().pagoProperty());
            colPago.setCellFactory(CheckBoxTableCell.forTableColumn(colPago));

            colItem.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescricao()));
            colDia.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getDia())));
            colValor.setCellValueFactory(c -> new SimpleStringProperty(formatarMoeda(c.getValue().getValor())));
        }

        private void ligarTabelaEntradasSaidas(){
            tabelaEntradasSaidas.setItems(listaES);

            colDescricaoES.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescricao()));
            colTipoES.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTipo()));
            colValorES.setCellValueFactory(c -> new SimpleStringProperty(formatarMoeda(c.getValue().getValor())));
        }

        private void ligarTabelaGastos(){
            tabelaGastos.setItems(listaGastos);

            colDescricaoG.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescricao()));
            colDataG.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getData().format(formatoData)));
            colCategoriaG.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCategoria()));
            colValorG.setCellValueFactory(c -> new SimpleStringProperty(formatarMoeda(c.getValue().getValor())));
        }
}
