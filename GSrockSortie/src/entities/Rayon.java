/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author anass
 */
public class Rayon {
    private static int id;
    private String codeRayon;

    public Rayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public static int getId() {
        return id;
    }


    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }
    
    
}
