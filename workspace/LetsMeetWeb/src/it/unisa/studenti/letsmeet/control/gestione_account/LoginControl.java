package it.unisa.studenti.letsmeet.control.gestione_account;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.unisa.studenti.letsmeet.manager.DaoException;
import it.unisa.studenti.letsmeet.manager.UtenteDao;
import it.unisa.studenti.letsmeet.manager.UtenteSqlDao;
import it.unisa.studenti.letsmeet.model.CredentialsBean;
import it.unisa.studenti.letsmeet.model.DataSourceSingleton;
import it.unisa.studenti.letsmeet.model.UtenteBean;

/**
 * Servlet implementation class loginControl
 */
@WebServlet("/loginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private static final String USERNAME = null;


	private static final String PASSWORD = null;

    
	DataSource ds;

	public static final String ID_IN_SESSION = "idUtente";
	public static final String USERNAME_IN_SESSION = "username";
	public static final String IS_LOGGED_IN_SESSION = "isLogged";


	
    public LoginControl() throws NamingException {
    	ds = DataSourceSingleton.getDataSource();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();
		if(!params.containsKey(USERNAME) || !params.containsKey(PASSWORD)) {
			response.getWriter().append("{\"error\":\"Manca qualche parametro\", \"errorcode\":1, \"data\":null}");
			return;
		}
		
		
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			UtenteDao dao = new UtenteSqlDao(conn);
			UtenteBean utente = dao.getByUsername(request.getParameter(USERNAME));
			
			if(utente == null) {
				response.getWriter().append("{\"error\":\"Username o password non validi\", \"errorcode\":3, \"data\":null}");
				return;
			}
			
			CredentialsBean creds = utente.getCredentials();
			
			String password = request.getParameter(PASSWORD);
			
			MessageDigest digest = null;
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				response.getWriter().append("{\"error\":\"Impossibile controllare psw\", \"errorcode\":2, \"data\":null}");
				return;
			}
			
			byte[] hashedPsw = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			byte[] hashedStoredPassword = creds.getPassword();
			
			if(hashedPsw.equals(hashedStoredPassword)) {
				HttpSession session = request.getSession();
				session.setAttribute(IS_LOGGED_IN_SESSION, true);
				session.setAttribute(ID_IN_SESSION, utente.getIdUtente());
				session.setAttribute(USERNAME_IN_SESSION, creds.getUsername());
				response.getWriter().append("{\"error\":\"\", \"errorcode\":0, \"data\":null}");
				return;
			}
			response.getWriter().append("{\"error\":\"Username o password non validi\", \"errorcode\":3, \"data\":null}");
			return;
		}catch (DaoException e) {
			response.getWriter().append("{\"error\":\"Qualcosa � andato storto\", \"errorcode\":4, \"data\":null}");
			return;
		}catch (SQLException e) {
			response.getWriter().append("{\"error\":\"Qualcosa � andato storto con mysql\", \"errorcode\":5, \"data\":null}");
			return;		
		}finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					//do nothing
				}
		}
	}

}
