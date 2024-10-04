/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.variables;

import exceptions.InvalidFormatException;

/**
 *
 * @author tarde
 */
public class MyDate {
    private String str;

    public MyDate(String str) throws InvalidFormatException {
        this.setStr(str);
    }
    
    public String getStr() {
        return str;
    }

    public void setStr(String str) throws InvalidFormatException {
        if (str != null && !this.rightDate(str)) {
            throw new InvalidFormatException("Fecha");
        }
        this.str = str;
    }
    
    public boolean rightDate(String str){
        return str.matches("\\d{2}-\\d{2}-\\d{4}");
    }
    @Override
    public String toString(){
        return this.str;
    }
}
