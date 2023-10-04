/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
  private String name;
  private WorkerLevel  level ; 
  private Double baseSalary;

    public Worker(String name, WorkerLevel level, Double baseSalary) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
    }
    /*Criando associacao com Departament
    pois e sabido que um Worker esta associado
    a um Departament.
    */
    private Departament departament;
  /*Criando outa associacao: E Sabido que um
    Pode Possuir Varios Contracts
    para isso usarei a Classe
    List
    */
    //LIsta de contratos (vazia) para serem adcionados ou removidos contratos
    private List<HourContract> contracts= new ArrayList();

    public Worker() {
    }
/*Quando temos uma composicao para muitos 
    a variavel de da nossa Lista nao deve estar
    no construtor e ela deve ser
    instanicada logo na 
    */
    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
        
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
    public void addContract(HourContract contract){
        //Addicionando contratos a lista
        contracts.add(contract);
        
    }
    public void removeContract(HourContract contract){
       // Removendo contratos da Lista
        contracts.remove(contract);
    }
    public Double income(int year, int month){
       double sum = baseSalary;
        Calendar cal= Calendar.getInstance();
       for(HourContract c: contracts){
           cal.setTime(c.getDate());
           int c_year = cal.get(Calendar.YEAR);
           int c_month= cal.get(Calendar.MONTH);
           if(year == c_year && 1+ month ==c_month){
              sum += c.totalValue();
           }
       }
       return sum;
    }
   
}
