
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iammt
 */
public class RequestSendToServer implements Serializable
{
   public String type;
   public String value;
    public RequestSendToServer (String type ,String value ){
        this.type=type;
        this.value=value;
    }
 }
