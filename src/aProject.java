
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Node;
import org.jsoup.select.*;


public class aProject {


    public static void main(String[] args) throws IOException {
        ArrayList<String> zona = new ArrayList<String>();
        ArrayList<String> via = new ArrayList<String>();
        ArrayList<String> daZona = new ArrayList<String>();
        ArrayList<String> aZona = new ArrayList<String>();
        ArrayList<String> giornoDivieto= new ArrayList<String>();

        Document doc = Jsoup.connect("http://cagliariportaaporta.it/2018/03/27/divieti-di-sosta/").get();
        Element body = doc.body();
        Element myEl = body.child(3).child(1).child(0).child(0).child(1).child(0).child(6).child(4).child(1);
        String str = myEl.tagName();
        System.out.println("La mia tag attuale è " + str );

        for(Element el: myEl.getAllElements()){
            if(el.tagName().equals("tr")){

                for(int i = 2; i < 10; i ++){

                    switch (i){
                        case 2:
                            zona.add(el.child(i).text());

                            break;
                        case 3:
                            via.add(el.child(i).text());

                            break;

                        case 5:
                            daZona.add(el.child(i).text());

                            break;
                        case 6:
                            aZona.add(el.child(i).text());
                            break;
                        case 7:
                            giornoDivieto.add(el.child(i).text());
                            System.out.println(el.child(i).text());
                            break;
                        default:
                            break;
                    }
                }
            }

        }
        for (int i = 0; i < zona.size(); i++) {
             str = "ZONA: " + zona.get(i) + " VIA: " + via.get(i) + " DA: " + daZona.get(i) + " A: " + aZona.get(i) + " GIORNO DI DIVIETO: " + giornoDivieto.get(i);
                    System.out.println(str);
        }




    }

}
