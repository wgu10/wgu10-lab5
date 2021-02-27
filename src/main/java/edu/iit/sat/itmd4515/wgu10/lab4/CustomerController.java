/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.wgu10.lab4;

import edu.iit.sat.itmd4515.wgu10.domain.Pet;
import edu.iit.sat.itmd4515.wgu10.lab4.Customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;

// important - use javax.validation.Validator as import
import javax.validation.Validator;

/**
 *
 * @author ganGuwen
 */
@WebServlet(name = "CustomerController", urlPatterns = "/cust")
public class CustomerController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());

    private Pet pet;
    
    @Resource
    Validator validator;

    @Resource(lookup = "java:app/jdbc/itmd4515DS")
    DataSource ds;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Inside CustomerController.doPost");

        try {

            // lab 4 - accepted user input from HTMl form/view
            String custIdStr = req.getParameter("custId");
            String custFirstName = req.getParameter("custFirstName");
            String custLastName = req.getParameter("custLastName");
            String custEmail = req.getParameter("custEmail");
            String comments = req.getParameter("comments");

            Integer custId = null;

            // lower-level validation for converstin from client-side text input to java data-type
            if ((custIdStr != null) && !(custIdStr.isEmpty())) {
                custId = Integer.valueOf(custIdStr);
            }

            // instantiated our pojo based on user input
            Customer customer = new Customer(custId, custFirstName, custLastName, custEmail);
            LOG.info(customer.toString());

            // validate our pojo using BV constraints
            Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

            // check the result of that validation
            // if the size of violations collection is not 0, we have  problem
            if (violations.size() > 0) {
                LOG.info("There was an issue validating the customer.");

                // log the problems
                for (ConstraintViolation<Customer> violation : violations) {
                    LOG.info(violation.getPropertyPath() + ":\t" + violation.getMessage());
                }

                // put the problems and the failed user input back into the request
                req.setAttribute("problems", violations);
                req.setAttribute("cust", customer);

                // send it back to the user for correction
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/cust.jsp");
                dispatcher.forward(req, resp);

                // otherwise, there were no issues with validation
            } else {
                LOG.info("There were no issues validating the customer.");

                // graduate students, if successful, write to DB
                String INSERT_SQL = "insert into Customer "
                        + "(CustomerId, FirstName, LastName, Email) "
                        + "values (?,?,?,?)";

                try( Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(INSERT_SQL)){
                    ps.setInt(1, customer.getId());
                    ps.setString(2, customer.getFirstName());
                    ps.setString(3, customer.getLastName());
                    ps.setString(4, customer.getEmail());
                    
                    ps.executeUpdate();
                }
                
                req.setAttribute("cust", customer);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/custConf.jsp");
                dispatcher.forward(req, resp);
            }
        } catch( Exception e ){
            LOG.log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Inside CustomerController.doGet");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/cust.jsp");
        dispatcher.forward(req, resp);
    }

}
