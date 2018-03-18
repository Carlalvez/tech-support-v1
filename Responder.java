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
    HashMap<String, String> respMap;

    /**
     * Construct a Responder - nothing to do
     */

    public Responder()
    {   
        nAleatorio = new Random();
        resp = new ArrayList<String>();
        resp.add ("Explicamelo de nuevo");
        resp.add ("Como hago eso?");
        resp.add ("Lo siento!");
        resp.add ("Genial");

        respMap = new HashMap<String, String>();
        fillRespMap();
    }

    /**
     * Introducir en el mapa de respuestas las palabras claves y sus respuestas
     */
    public void fillRespMap()
    {
        respMap.put("lento","Algo no funciona como debiera");
        respMap.put("error","Se ha detectado un error, no se preocupe estamos trabajando en ello");
        respMap.put("problema","Ese problema es muy facil de solucionar, reinicie su equipo");
        respMap.put("Sonido","Su tarjeta de sonido ha quedado obsoleta, se recomienda cambiarla");
    }

    public String generateResponse (HashSet<String> word)
    {
        String response = null;
        
        Iterator<String> iterator = word.iterator();
        boolean search = true;
        
        while (iterator.hasNext() && search)
        {
            response = respMap.get(iterator.next());
            
            if (response != null)
            {
                search = false;
            }
        }
        
        if (response == null)
        {
            response = resp.get(nAleatorio.nextInt(resp.size()));
        }
        
        return response;
    }

    /**
     * Displayed a response.
     * @return   A string that should be displayed as the response
     */
    public String pickDefaultResponse()
    {
        int num = nAleatorio.nextInt(6);
        return resp.get(num);
    }
}