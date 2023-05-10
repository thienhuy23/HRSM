/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.Utils;

import com.hrsm.Entity.nguoiDung;

/**
 *
 * @author lenovo
 */
public class Auth {

    public static nguoiDung user = null;

    public static void clear() {
        Auth.user = null;
    }
    /**
     * @return
     */
    public static boolean isLogin() {
        return Auth.user != null;
    }
    /**
     * @return
     */
    public static boolean isManager() {
        return Auth.isLogin() && user.getVaiTro();
    }
    
    public static String getName(){
        return user.getHoTen();
    }
}
