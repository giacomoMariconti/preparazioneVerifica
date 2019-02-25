
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mariconti_giacomo
 */
public class trovaDocenti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        List docenti=null;
        parserDocenti dom = new parserDocenti();
        //String s = tastiera.nextLine();
        try{
        docenti = dom.parseDocument("circolare.xml");
            //System.out.println("inserisci giorno");
            //String giorno=tastiera.nextLine();
        }catch(ParserConfigurationException | SAXException | IOException exception){
             System.out.println("Errore!");
        }
       
       //iterazione della lista e visualizzazione degli oggetti
        Iterator iterator = docenti.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

    }
    
}
