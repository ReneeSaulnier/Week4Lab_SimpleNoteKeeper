/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Renee
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        try{
             // Setting the file path
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // Reading the text file
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            // Reading in the values into variables
            String title = br.readLine();
            String contents = br.readLine();
            // Creating a new instance of note 
            Note note = new Note(title, contents);
            // Setting the attribute for the jsp
            request.setAttribute("note", note);
        } catch (IOException e){
            
        }              
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Requesting the parameters to be written
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        // Setting the file path
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // Reading the text file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));      
        // Reading in the values into variables
        pw.write(title);
        pw.write(contents);
        // Creating a new instance of note 
        Note note = new Note(title, contents);
        // Setting the attribute for the jsp
        request.setAttribute("note", note);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
           
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}