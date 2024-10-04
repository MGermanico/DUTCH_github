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
public class Nickname {
    private String str;

    public Nickname(String str) throws InvalidFormatException {
        this.setStr(str);
    }
    
    public String getStr() {
        return str;
    }

    public void setStr(String str) throws InvalidFormatException {
        if (str != null && !rightNickname(str)) {
            throw new InvalidFormatException("Nickname");
        }
        this.str = str;
    }
    
    public boolean rightNickname(String str){
        int nameLength = str.length();
        return !(nameLength < 3 || nameLength > 20);
    }
    
    @Override
    public String toString(){
        return this.str;
    }
}
