/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.wgu10.domain;

/**
 *
 * @author ganGuwen
 */
public enum PetType {
    
    CANINE("Dog"),
    FELINE("Kitty"),
    REPTILE("Snake"),
    RABBIT("Bunny"),
    FISH("Fishy");
    
    private String label;

    private PetType(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return label;
    }
    
}
