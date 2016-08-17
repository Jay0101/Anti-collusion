/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gr_man extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String ips="";
        try {
            if((request.getParameter("username").equalsIgnoreCase("admin"))&&(request.getParameter("password").equalsIgnoreCase("admin"))){
                        InetAddress ip;
                        try {
			
                                ip = InetAddress.getLocalHost();		
                                NetworkInterface network = NetworkInterface.getByInetAddress(ip);			
                                byte[] mac = network.getHardwareAddress();                            
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < mac.length; i++) {
                                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                                }
                                ips=sb.toString();
                                System.out.println("Mac is: "+ips);
                            } catch (UnknownHostException e) {		
                                        e.printStackTrace();		
                            } catch (SocketException e){			
                                        e.printStackTrace();
			
                            }
                        if(ips.equalsIgnoreCase("02-68-09-66-76-0E")){                            
                            response.sendRedirect("adminHome.jsp");
                        }
                        else{
                            response.sendRedirect("verification.jsp");    
                        }
            }
            else
            out.println("<p style='margin-left:550px;margin-top:100px;font-family: cursive '>Check Username / Password....!</p>");
            
        } catch (Exception ex) {
            Logger.getLogger(Gr_man.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
