package com.sujsun.cms;

import java.io.IOException;

import javax.servlet.http.*;

import org.mortbay.log.Log;

@SuppressWarnings("serial")
public class Sujsun_CMSServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String returnMessage = "Hello, world";
		System.out.println( returnMessage );
		resp.setContentType("text/plain");
		resp.getWriter().println( returnMessage );
	}
}
