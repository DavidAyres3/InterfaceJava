package Program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;


public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Número do contrato");
        int number = sc.nextInt();
        
        System.out.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        
        System.out.println("Valor do contrato: ");
        double totalValue = sc.nextDouble();
        
        Contract obj = new Contract(number, date, totalValue);        
        
        System.out.print("Entre com o número de parcelas: ");
        int  n = sc.nextInt();
        
        ContractService contractService = new ContractService(new PaypalService());
        
        contractService.processContract(obj, n);
        
        System.out.println("Parcelas: ");
        
        for(Installment installment : obj.getInstalments()){
            System.out.println(installment);
        }
        
        
        
        sc.close();
    }
}
