package java112.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(
        name = "madlibs",
        urlPatterns = {"/MadLibGame"}
)

public class MadLibsServlet extends HttpServlet {
    /**
     * Handles HTTP Post requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String noun = request.getParameter("noun");
        String verb = request.getParameter("verb");
        String adjective = request.getParameter("adjective");
        String adverb = request.getParameter("adverb");
        String name = request.getParameter("name");

        // Set the values
        MadLibsBean madlibsBean = new MadLibsBean();
        madlibsBean.setNoun(noun);
        madlibsBean.setVerb(verb);
        madlibsBean.setAdjective(adjective);
        madlibsBean.setAdverb(adverb);
        madlibsBean.setName(name);

        request.setAttribute("madLibsBean", madlibsBean);

        // Ask the view to take care of the values
        String url = "/madLibsResult.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
