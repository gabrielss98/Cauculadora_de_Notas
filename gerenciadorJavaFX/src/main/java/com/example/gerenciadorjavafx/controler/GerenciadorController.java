package com.example.gerenciadorjavafx.controler;

import com.example.gerenciadorjavafx.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenciadorController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Label lblError;

    @FXML
    private TableView<Aluno> tabelaAlunos;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

    private ObservableList<Aluno> alunosData;

    @FXML
    void initialize() {



        this.alunosData = FXCollections.observableArrayList();

        TableColumn nomeColuna = new TableColumn("Nome");
        TableColumn n1Coluna = new TableColumn("Nota 1");
        TableColumn n2Coluna = new TableColumn("Nota 2");
        TableColumn n3Coluna = new TableColumn("Nota 3");
        TableColumn mediaColuna = new TableColumn("Media");
        TableColumn situacaoColuna = new TableColumn("Situação");


        nomeColuna.setCellValueFactory(new PropertyValueFactory<Aluno,String>("nome"));
        n1Coluna.setCellValueFactory(new PropertyValueFactory<Aluno,Double>("nota1"));
        n2Coluna.setCellValueFactory(new PropertyValueFactory<Aluno,Double>("nota2"));
        n3Coluna.setCellValueFactory(new PropertyValueFactory<Aluno,Double>("nota3"));
        mediaColuna.setCellValueFactory(new PropertyValueFactory<Aluno,Double>("media"));
        situacaoColuna.setCellValueFactory(new PropertyValueFactory<Aluno,Double>("situacao"));

        this.tabelaAlunos.getColumns().addAll(nomeColuna,n1Coluna,n2Coluna,n3Coluna,mediaColuna,situacaoColuna);
        this.tabelaAlunos.setItems(alunosData);


        this.alunosData.addAll(new Aluno("João",10,10,10), new Aluno("Leandrin",3,7,10));
    }

    @FXML
    void btnAdicionarAction(ActionEvent event) {
        try {
            Aluno novoAluno = new Aluno(this.txtNome.getText(),
                    Double.parseDouble(this.txtNota1.getText()),
                    Double.parseDouble(this.txtNota2.getText()),
                    Double.parseDouble(this.txtNota3.getText()));

            System.out.println(novoAluno.getNome());
            this.alunosData.add(novoAluno);
            this.clearAll();

        } catch (Exception e) {
            this.lblError.setText("Entradas invalidas!");
        }

    }


    @FXML
    void btnAterarAction(ActionEvent event) {

        int i = this.tabelaAlunos.getSelectionModel().getSelectedIndex();

        if ( i >= 0){
            try {
                Aluno novoAluno = new Aluno(this.txtNome.getText(),
                        Double.parseDouble(this.txtNota1.getText()),
                        Double.parseDouble(this.txtNota2.getText()),
                        Double.parseDouble(this.txtNota3.getText()));


                this.alunosData.set(i,novoAluno);
                this.clearAll();

            } catch (Exception e) {
                this.lblError.setText("Entradas invalidas!");
            }
        }

    }

    @FXML
    void btnExcluirrAction(ActionEvent event) {

        int i = this.tabelaAlunos.getSelectionModel().getSelectedIndex();

        if (i >=0){
            this.alunosData.remove(i);
        }

    }

    private void clearAll() {
        this.txtNome.clear();
        this.txtNota1.clear();
        this.txtNota2.clear();
        this.txtNota3.clear();
        this.lblError.setText("");
    }

}
