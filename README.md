5
Aufgabe 4.3.2
(Hier aufbauend auf der Lösung zu 4.2.1.a), die View-Klassen sind die Observer.)
Klasse BaelleModel
public class BaelleModel extends Observable {
…
// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
public void leseBaelleAusDatei()
throws Exception{
BufferedReader ein
= new BufferedReader(new FileReader("Baelle.csv"));
…
ein.close();
setChanged();
notifyObservers();
}
…
}
Klasse BaelleView
public class BaelleView implements Observer{
…
@Override
public void update(Observable o, Object arg){
if(o.getClass().getSimpleName().equals("BaelleModel")){
cmbBxEinkaufdatum.getItems().clear();
for(int i = 0; i < baelleModel.getAnzahlBaelle(); i++) {
…
}
}
} …
}
Klasse SportartikelView
public class SportartikelView implements Observer{
…
@Override
public void update(Observer o, Object arg) {
if(o.getClass().getSimpleName().equals("BaelleModel")){
String text = "";
for(int i = 0; i < baelleModel.holeBaelle().length; i++) {
…
}
txtAnzeigeBaelle.setText(text);
}
} …
}
6
Aufgabe 4.3.3
In Klasse SportartikelView
private SportartikelControl sportartikelControl;
private BaelleModel baelleModel;
private Stage stage;
public SportartikelView(SportartikelControl sportartikelControl,
Stage stage, BaelleModel baelleModel){
Scene scene = new Scene(this.pane, 640, 340);
…
this.baelleModel = baelleModel;
this.baelleModel.addObserver(this);
this.stage = stage;
this.initKomponenten();
this.initListener();
}
private void initListener() {
…
stage.setOnCloseRequest(
new EventHandler<WindowEvent>() {
@Override
public void handle(WindowEvent e) {
SportartikelView.this.baelleModel
.removeObserver(SportartikelView.this);
}
});
}
@Override
public void update(Observable o, Object arg) {
// public void update() {
if(o.getClass().getSimpleName().equals("BaelleModel")) {
if(baelleModel.holeBaelle() != null){
String text = "";
for(int i = 0; i < baelleModel.holeBaelle().length;
i++) {
text = text + baelleModel.holeBaelle()[i]
.gibZurueck('|') + "\n";
}
txtAnzeigeBaelle.setText(text);
zeigeInformationsfensterAn(
"Beachten Sie die Anzeige!");
}
else{
zeigeInformationsfensterAn(
"Bisher wurden keine Bälle gelesen!");
}
}
}
