import javax.servlet.*;        
import java.io.IOException;  

public class CharacterEncodingFilter implements Filter { 
	
    protected FilterConfig filterConfig = null;        
    protected String encoding = "";        
       
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {        
        if(encoding != null)        
            servletRequest.setCharacterEncoding(encoding);  
        System.out.println("yes"+encoding);
        filterChain.doFilter(servletRequest, servletResponse);        
    }        
           
    public void destroy() {        
        filterConfig = null;        
        encoding = null;        
    }        
           
    public void init(FilterConfig filterConfig) throws ServletException {        
        this.filterConfig = filterConfig;        
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println("yes"+encoding);   
    }        
}       
