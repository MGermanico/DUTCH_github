/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import utils.StringUtils;

/**
 *
 * @author tarde
 */
public class TestUtils {
    public static void main(String[] args) {
        String str = "a";
        str = StringUtils.changeChar(str, 'X', 2);
        str = StringUtils.setLong(str, 8, false);
        System.out.println(str);
    }
}
