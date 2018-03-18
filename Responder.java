import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Carlos Alvarez
 * @version    15/03/2018
 */
public class Responder
{
    Random nAleatorio;
    ArrayList<String> resp;
    private HashMap<HashSet<String>, String> respMap;

    /**
     * Construct a Responder - nothing to do
     */

    public Responder()
    {   
        nAleatorio = new Random();

        respMap = new HashMap<>();
        DefaultResponses();

    }

    /**
     * Introducir en el mapa de respuestas las palabras claves y sus respuestas
     */
    public void fillRespMap()
    {
        HashSet<String> set01 = new HashSet<>();
        set01.add("free");
        set01.add("app");

        HashSet<String> set02 = new HashSet<>();
        set02.add("free");

        HashSet<String> set03 = new HashSet<>();
        set03.add("app");

        HashSet<String> set04 = new HashSet<>();
        set04.add("problema");
        set04.add("error");
        set04.add("lento");

        respMap.put(set04,"Se ha detectado un error, no se preocupe estamos trabajando en ello");
        respMap.put(set01,"algo no funciona como debiera");
        respMap.put(set02,"reinicie su equipo");
        respMap.put(set03,"Su tarjeta de sonido ha quedado obsoleta, se recomienda cambiarla");
    }

    public String generateResponse (HashSet<String> word)
    {
        String response = null;

        response = respMap.get(word);

        if (resp.size() > 0){
            response = resp.remove(nAleatorio.nextInt(resp.size()));
        }
        else{
            response = "Lo siento, no entiendo la pregunta";
        }

        return response;
    }

    /**
     * Displayed a response.
     * @return   A string that should be displayed as the response
     */
    public String pickDefaultResponse()
    {   int num = nAleatorio.nextInt(6);
        return resp.get(num);
    }
    
    private void DefaultResponses()
    {
       resp = new ArrayList<String>();
       resp.add("Muy interesante");
       resp.add("No lo entiendo");
       resp.add("Alguna duda mas?");
       resp.add("Lo siento, no puedo ayudarle");
       resp.add("Buena idea");
    }
}