package App.filter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import App.utils.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Jwtfilter extends OncePerRequestFilter {
	
	private final JwtService jwtservice;
	
	public Jwtfilter(JwtService jwtservice)
	{
		this.jwtservice=jwtservice;
	}

	@Override
	protected void doFilterInternal
	       (HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)throws ServletException, IOException {
		
		String authHeader= request.getHeader("Authorization");
		String token=null;
		
		if(authHeader!=null&&authHeader.startsWith("Bearer "))
		{
			token=authHeader.substring(7);
			
			if(jwtservice.validateToken(token))
			{
				String userName=jwtservice.extractUsername(token);
				
				UsernamePasswordAuthenticationToken authtoken=new UsernamePasswordAuthenticationToken(userName,null,Collections.emptyList());
				
				SecurityContextHolder.getContext().setAuthentication(authtoken);
			}
		}
		
		
		 filterChain.doFilter(request, response);
	}

}
