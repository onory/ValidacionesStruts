/*
 * Implementacion de validaciones
 */
package beans.actions;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({ //usando anotaciones, se puede sustutir los direccionamientos de struts.xml para 2 resultados
      
    @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"), //para efecto de success
    @Result(name="input", location="/WEB-INF/content/login.jsp") //para efectos de fail en input se envia directamente sin redireccionamiento, para evitar perder los errores
})
public class ValidarUsuarioAction extends ActionSupport {
    
    Logger log = LogManager.getLogger(LoginAction.class); // envia informacion a la consola
    
    //atributo para mandar informacion desde el cliente
    
    private String usuario;
     private String password;
    
//notacion que define a strut, sin struts.xml es llamado desde login.jsp  
   @Action("validarUsuario")
     public String execute(){
        
    if("admin".equals(this.usuario)){
        //addActionMessage envia un mensaje de ok tras validacion 
                        //getText opyiene texto de properties
        addActionMessage(getText("usuario.valido"));
        
        return SUCCESS; // proporciona correcto y continua
    }else{
       return INPUT; //regresa a pjsp default es decir login.jsp
        
    }
        
    }
     //Validate genera una validacion de datos de entrada
     @Override
     public void validate(){
         if(this.usuario==null || "".equals(this.usuario.trim())){//valida el campo de usuario es nulo o vacio
             //si es erroneo muesta en addFielError mensjae
                         //campo a validar 
                                    //optiene el texto de properties
             addFieldError("usuario",getText("val.usuario"));
         }
         else if(!usuarioValido()){ // valida si el usuario es admin por metoso usuarioValido
             addActionError(getText("usuario.invalido"));
             
         }
         
          if(this.password==null || "".equals(this.password.trim())){//valida el campo de password es nulo o vacio
             //si es erroneo muesta en addFielError mensjae
                         //campo a validar 
                                    //optiene el texto de properties
             addFieldError("password",getText("val.password"));
         }
         else if(this.password.length() < 3){ // valida si el password es almenos de 3 caracteres
            addFieldError("password",getText("val.pass.min.lenght"));
             
         }
     }
     
     // valida si el usuario es admin dentro del else if
     private boolean usuarioValido(){
         return "admin".equals(this.usuario);
     }
     

//gets y sets    

    public String getUsuario() {
        return usuario;
    }

        public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
        public String getPassword() {
        return password;
    }

        public void setPassword(String password) {
        this.password = password;
    }
    
}
