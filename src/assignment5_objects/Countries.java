/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_objects;

/**
 *
 * @author Joe
 */
public class Countries {
    String code;
    String name;
    String continent;
    long pop;
    long size;

    public Countries(String code, String name, String continent, String pop, String size){
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.pop = Long.parseLong(pop);
        this.size = Long.parseLong(size);
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPop() {
        return pop;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
 
    
}
