package gui;

import business.CafeVerwaltung;
import business.CafeVerwaltungModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class CafeVerwaltungView implements Observer {
    
  
    private Pane pane                        = new  Pane();
    private Label lblEingabe                 = new Label("Eingabe");
    private Label lblAnzeige                 = new Label("Anzeige");
    
    private Label lblName                    = new Label("Name:");
    private Label lblOrt                     = new Label("Ort");
    private Label lblBeschreibung            = new Label("Beschreibung");
    private Label lblAngeschlossenerCafe     = new Label("Angeschlossener Cafe?");
    private Label lblKafeeProdukte           = new Label("Kaffee Produkte");
    
    private TextField txtName                = new TextField();
    private TextField txtOrt                 = new TextField();
    private TextField txtBeschreibung        = new TextField();
    private TextField txtAngeschlossenerCafe = new TextField();
    private TextField txtKafeeProdukte       = new TextField();
    
    private TextArea txtAnzeige              = new TextArea();
    private Button btnEingabe                = new Button("Eingabe");
    private Button btnAnzeige                = new Button("Anzeige");
    private MenuBar mnbrMenuLeiste           = new MenuBar();
    private Menu mnDatei                     = new Menu("Datei");
    private MenuItem mnItmCsvImport          = new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport          = new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport          = new MenuItem("csv-Export");
 
    

    private CafeVerwaltungModel cafeVerwaltungModel;
    private CafeVerwaltungControl cafeVerwaltungControl;
    private CafeVerwaltung cafeVerwaltung;
    
    
    public CafeVerwaltungView(CafeVerwaltungControl cafeVerwaltungControl, CafeVerwaltungModel cafeVerwaltungModel, Stage primaryStage) {
        this.cafeVerwaltungControl = cafeVerwaltungControl;
        this.cafeVerwaltungModel = cafeVerwaltungModel;
        
        this.cafeVerwaltungModel.addObserver(this);
        
        Scene scene = new Scene(this.pane, 700, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verwaltung von Cafes");
        primaryStage.show();
        this.initKomponenten();
        this.initListener();
    }
    
    private void initKomponenten() {
        // Labels
        lblEingabe.setLayoutX(20);
        lblEingabe.setLayoutY(40);
        Font font = new Font("Arial", 24); 
        lblEingabe.setFont(font);
        lblEingabe.setStyle("-fx-font-weight: bold;"); 
        lblAnzeige.setLayoutX(400);
        lblAnzeige.setLayoutY(40);
        lblAnzeige.setFont(font);
        lblAnzeige.setStyle("-fx-font-weight: bold;"); 
        lblName.setLayoutX(20);
        lblName.setLayoutY(90);
        lblOrt.setLayoutX(20);
        lblOrt.setLayoutY(130);
        lblBeschreibung.setLayoutX(20);
        lblBeschreibung.setLayoutY(170);
        lblAngeschlossenerCafe.setLayoutX(20);
        lblAngeschlossenerCafe.setLayoutY(210);
        lblKafeeProdukte.setLayoutX(20);
        lblKafeeProdukte.setLayoutY(250);        
        pane.getChildren().addAll(lblEingabe, lblAnzeige, 
            lblName, lblOrt, lblBeschreibung,
            lblAngeschlossenerCafe, lblKafeeProdukte);
    
        // Textfelder
        txtName.setLayoutX(170);
        txtName.setLayoutY(90);
        txtName.setPrefWidth(200);
        txtOrt.setLayoutX(170);
        txtOrt.setLayoutY(130);
        txtOrt.setPrefWidth(200);
        txtBeschreibung.setLayoutX(170);
        txtBeschreibung.setLayoutY(170);
        txtBeschreibung.setPrefWidth(200);
        txtAngeschlossenerCafe.setLayoutX(170);
        txtAngeschlossenerCafe.setLayoutY(210);
        txtAngeschlossenerCafe.setPrefWidth(200);
        txtKafeeProdukte.setLayoutX(170);
        txtKafeeProdukte.setLayoutY(250);
        txtKafeeProdukte.setPrefWidth(200);
        pane.getChildren().addAll( 
            txtName, txtOrt, txtBeschreibung,
            txtAngeschlossenerCafe, txtKafeeProdukte);
        
        // Textbereich    
        txtAnzeige.setEditable(false);
        txtAnzeige.setLayoutX(400);
        txtAnzeige.setLayoutY(90);
        txtAnzeige.setPrefWidth(270);
        txtAnzeige.setPrefHeight(185);
        pane.getChildren().add(txtAnzeige); 
        
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
        // Menü
        this.mnbrMenuLeiste.getMenus().add(mnDatei);
        this.mnDatei.getItems().add(mnItmCsvImport);
        this.mnDatei.getItems().add(mnItmTxtImport);
        this.mnDatei.getItems().add(new SeparatorMenuItem());
        this.mnDatei.getItems().add(mnItmCsvExport);
        pane.getChildren().add(mnbrMenuLeiste);
    }
    
    private void initListener() {
        // Neue funktionierende Funktionen mit Lambda-Ausdruck 
        btnEingabe.setOnAction(ae->{
            nehmeCafeVerwaltungAuf();
        });
        
        btnAnzeige.setOnAction(ae->{
            zeigeCafeVerwaltungAn();
        });
        
        mnItmCsvImport.setOnAction(ae->{
            cafeVerwaltungControl.leseCafeVerwaltungAusDatei("csv");
        });
        
        mnItmTxtImport.setOnAction(ae->{
            cafeVerwaltungControl.leseCafeVerwaltungAusDatei("txt");
        });
        
        mnItmCsvExport.setOnAction(ae->{
            cafeVerwaltungControl.schreibeCafeVerwaltungInDatei();
        });
    }
    
    public void nehmeCafeVerwaltungAuf() {
        try {
            this.cafeVerwaltung = new CafeVerwaltung(
                txtName.getText(),
                txtOrt.getText(),
                txtBeschreibung.getText(),
                txtKafeeProdukte.getText().split(";"),
                txtAngeschlossenerCafe.getText()
            );
            cafeVerwaltungModel.setCafeVerwaltung(cafeVerwaltung);
            zeigeInformationsfensterAn("Die Produkte wurden aufgenommen!");
            
        }
        catch(Exception exc) {
            zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }
    
    public void zeigeCafeVerwaltungAn() {
        // Über das Modell auf cafeVerwaltung zugreifen
        CafeVerwaltung aktuelleVerwaltung = this.cafeVerwaltungModel.getCafeVerwaltung();

        if (aktuelleVerwaltung != null) {
           
            txtAnzeige.setText(aktuelleVerwaltung.gibCafeVerwaltungZuruck(' '));
        } else {
           
            zeigeInformationsfensterAn("Bisher wurde keine CafeVerwaltung aufgenommen.");
        }
    }
    
    public void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.INFORMATION,
            "Information", meldung).zeigeMeldungsfensterAn();
    }    
    
    public void zeigeFehlermeldungsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.ERROR,
            "Fehler", meldung).zeigeMeldungsfensterAn();
    }
    
     		
    @Override
    public void update() {
        
        zeigeCafeVerwaltungAn();
    }
}
