package dev.servlets;

import dev.beans.CartBean;
import dev.interfaces.Cart;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "shoppingCartServlet",urlPatterns = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String CART_SESSION_KEY = "shoppingCart";

    public ShoppingCartServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Hello from servlet");
        Cart cartBean = (Cart) request.getSession().getAttribute(CART_SESSION_KEY);

        if (cartBean == null) {
            // EJB is not yet in the HTTP session
            // This means that the client just sent his first request
            // We obtain a CartBean instance and add it to the session object.
            try {
                InitialContext ic = new InitialContext();
                cartBean = (Cart) ic.lookup("java:module/CartBean");

                request.getSession().setAttribute(CART_SESSION_KEY, cartBean);

                System.out.println("shoppingCart created");

            } catch (NamingException e) {
                throw new ServletException(e);
            }
        }

        String productName = request.getParameter("product");
        if (productName != null && productName.length() > 0) {

//            Product product = new Product();
//            product.setType(productName);
//            cartBean.addProductToCart(product);

            System.out.println("product " + productName + " added");
        }

        String checkout = request.getParameter("checkout");
        if (checkout != null && checkout.equalsIgnoreCase("yes")) {
            // Request instructs to complete the purchase
            cartBean.checkOut();
            System.out.println("Shopping cart checked out ");
        }

    }

}
