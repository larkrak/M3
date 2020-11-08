/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personmain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Isma
 */
public class Empleat extends Person{

    private Double salari;
    private String carrec;
    private String departament;
    private Integer anyIngres;
    ArrayList<String> arrayDepartaments = new ArrayList<String>();
    
    public Empleat() {
    }

    public Empleat(Double salari, String carrec, String departament, Integer anyIngres) {
        this.salari = salari;
        this.carrec = carrec;
        this.departament = departament;
        this.anyIngres = anyIngres;
        arrayDepartaments.add("Informatica");
        arrayDepartaments.add("Direccio");
        arrayDepartaments.add("Comercial");
    }

    public Empleat(Person p) {
        super(p);
    }

    public Empleat(Double salari, String carrec, String departament, Integer anyIngres, Person p) {
        super(p);
        this.salari = salari;
        this.carrec = carrec;
        this.departament = departament;
        this.anyIngres = anyIngres;
    }
    
    public Empleat(Empleat e) {
    }

    public Double getSalari() throws SalariInvalidException, PropertyNotInitializedException {
        if (salari==null) throw new PropertyNotInitializedException("the \"salari\" is not set");
        if (!validSalari(salari))throw new SalariInvalidException("The salari is not valid");
        return salari;
    }

    public void setSalari(Double salari) throws SalariInvalidException {
        if (!validSalari(salari)) throw new SalariInvalidException("The salari is not valid");
        this.salari = salari;
    }

    public boolean validSalari(Double salari){
        boolean flag = false;
        if(salari < 1108.3){
            flag = false;
        }else{
            Pattern p = Pattern.compile("^\\d{1,6}(\\.[0-9]{1,2})");
            Matcher m = p.matcher(salari.toString());
            flag = m.matches();
        }
        return flag;
    }
    
    public String getCarrec() {
        return carrec;
    }

    public void setCarrec(String carrec) {
        this.carrec = carrec;
    }

    public String getDepartament() throws PropertyNotInitializedException, DepartamentInvalidException {
        if(departament == null) throw new PropertyNotInitializedException("Departament no introduit");
        if(!validDep(departament)) throw new DepartamentInvalidException ("Departament no valid");
        return departament;
    }

    public void setDepartament(String departament) throws DepartamentInvalidException {
        if(!validDep(departament)) throw new DepartamentInvalidException("Departament no valid");
        this.departament = departament;
    }
    
    public boolean validDep(String dep){
        boolean flag = true;
        if(!arrayDepartaments.contains(dep)) flag = false;
        return flag;
    }

    public Integer getAnyIngres() {
        return anyIngres;
    }

    public void setAnyIngres(Integer anyIngres) {
        this.anyIngres = anyIngres;
    }
    
    

    
    
    
    
}
