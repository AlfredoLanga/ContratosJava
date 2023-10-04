/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;


public class Departament {
    private String name;

    public Departament(String name) {
        this.name = name;
    }
    public Departament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Departament{" + "name=" + name + '}';
    }

    
    
}
