/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.variables;

import exceptions.InvalidFormatException;

/**
 *
 * @author tarde
 */
public class MyColor {
    private String str;

    public MyColor(String str) throws InvalidFormatException {
        this.setStr(str);
    }
    
    public String getStr() {
        return str;
    }

    public void setStr(String str) throws InvalidFormatException {
        if (!this.rightColor(str)) {
            throw new InvalidFormatException("Color");
        }
        this.str = str;
    }
    
    public boolean rightColor(String str){
        boolean ret = str.matches("\\d{3},\\d{3},\\d{3}");
        if(ret){
            String rgbArr[] = str.split(",");
            for (int i = 0; i < rgbArr.length; i++) {
                if(Integer.parseInt(rgbArr[i]) > 255){
                    ret = false;
                    break;
                }
            }
        }
        return ret;
    }
}
