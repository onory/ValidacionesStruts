 /*
 * Esta clase procesa la peticion de la app web
*clase de tipo action
*es llamada por el struts para ejecutar execute
 */
package beans.actions;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

//se agrega concepto de anotaciones para evitat struts.xml
@Result(name="success", location="/WEB-INF/content/login.jsp")
public class LoginAction extends ActionSupport {
    
    @Action("login") //define la accion del execute por anotaciones
    public String execute(){
        return SUCCESS; 
    }
    
}
