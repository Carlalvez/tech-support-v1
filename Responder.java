import java.util.Random;
import java.util.ArrayList;

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
        
    /**
     * Construct a Responder - nothing to do
     */
    
    public Responder()
    {   
        nAleatorio = new Random();
        resp = new ArrayList<String>();
        resp.add ("Muy interesante");
        resp.add ("No lo entiendo");
        resp.add ("Alguna duda mas?");
        resp.add ("Lo siento, no puedo ayudarle");
        resp.add ("Buena idea");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int num = nAleatorio.nextInt(6);
        return resp.get(num);
    }
}
