/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.StudentInputter;
import bo.StudentManager;

/**
 * @author dinht
 */
public class StudentController {
    StudentManager sm;
    StudentInputter si;

    public StudentController(){
        sm = new StudentManager();
    }


}
