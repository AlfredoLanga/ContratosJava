
package contratos;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Contratos {

    public static void main(String[] args) throws ParseException {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM");
        System.out.println("Enter department's name:");
        String  departamentName = ler.next();
        System.out.println("Enter worker data:");
        System.out.println("Name:");
        String workerName = ler.next();
        System.out.println("Level");
        String workerLevel = ler.next();
        System.out.println("Base Salary");
        Double BaseSalary=ler.nextDouble();
       Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), BaseSalary,new Departament( departamentName));
       //Dados do Contracto Por Hora
        System.out.println("How many contracts to this worker?");
        int numberContracts = ler.nextInt();
        for(int i=0; i<numberContracts; i++){
        System.out.println("Enter contract"+i+" Data");
        System.out.println("Date (DD/MM/yyyy)");
        Date dateContract = sdf.parse(ler.next());
        System.out.println("Value of Hour: ");
        Double ValuePerHour =ler.nextDouble();
        System.out.println("Duration (Hours)");
        int duration = ler.nextInt();
        HourContract hourContract = new HourContract(dateContract, ValuePerHour, duration);
        worker.addContract(hourContract);
        
      
        }
        System.out.println(" ");
        System.out.println("Enter month and year to calculate income (MM/YYYY):");
        String yearMonth = ler.next();
        //Fazemos isso pois o mes e o ano devem ser numeros inteiros
        int year = Integer.parseInt(yearMonth.substring(0,2));
        int month = Integer.parseInt(yearMonth.substring(3));
        
        System.out.println("Name:"+worker.getName());
        System.out.println("Department: "+worker.getDepartament().getName());
        System.out.println("Income for "+yearMonth+ " : "+String.format("%2f", worker.income(year, month)));
        ler.close();
        
        
    }
    
}
