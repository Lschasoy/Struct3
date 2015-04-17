package controlador;

import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.config.ModuleConfig;

public class MundialAction extends org.apache.struts.action.Action
implements org.apache.struts.action.PlugIn
{
    private static final String SUCCESS = "success";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        ActionForward respuesta = null;
        try // ejecutamos la funcion de negocio
        {
            // Obtenemos acceso al formulario
            DynaActionForm formulario = (DynaActionForm) form;
            // aqui va la inserción de los datos
            int pais = Integer.parseInt(formulario.get("pais").toString());
            if (pais == 1)
            {
                // redirigimos a la presentación
                respuesta = mapping.findForward("correcto");
            }else{
                //mantenemos la vista actual
                respuesta = mapping.getInputForward();
            }
            System.out.println("El pais es: " + formulario.get("pais"));
            System.out.println("Observaciones: " + formulario.get("observaciones"));
        }
        catch(Exception ex) // en caso de problemas retornar a la página origen
        {
             // recuperamos acceso al JSP de origen
                            System.out.println("Excepcion "+ex);
            respuesta = mapping.getInputForward();
        }
        return respuesta; // redirigimos a la presentacion
    }

    @Override
    public void destroy() 
    {
        
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException 
    {
        Hashtable vPaises = new Hashtable();
        
        // aqui hay que poner el código que nos proporcione los datos de la base de datos
        vPaises.put("1","España"); 
        vPaises.put("2","Francia");
        vPaises.put("3","Brasil");
        vPaises.put("4","Holanda");
        vPaises.put("5","Argentina");
                // ponemos la tabla en el ambito de la aplicación
        servlet.getServletContext().setAttribute("tablapaises",vPaises);  
    }
}

