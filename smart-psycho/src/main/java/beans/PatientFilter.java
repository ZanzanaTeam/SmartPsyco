package beans;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Patient;
import domaine.Utilisateur;

@WebFilter(urlPatterns = "/patient/*")
public class PatientFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsf");
		} else {
			Utilisateur utilisateur = (Utilisateur) session
					.getAttribute("user");
			if (utilisateur instanceof Patient)
				chain.doFilter(req, res);
			else
				response.sendRedirect(request.getContextPath()
						+ "/accessdenied.jsf");
		}
	}

	@Override
	public void destroy() {

	}

}