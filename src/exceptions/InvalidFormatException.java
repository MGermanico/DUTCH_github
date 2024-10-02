/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author tarde
 */
public class InvalidFormatException extends Exception{
    public InvalidFormatException(){
        
    }
    public InvalidFormatException(String msg){
        super(msg);
    }
}
