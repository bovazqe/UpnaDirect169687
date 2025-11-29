package upnadirect;

import java.time.Year;

public class Cliente {
    private final int anoNacimiento;
    private final int salario;
    
    public Cliente(int anoNacimiento, int salario){
        this.anoNacimiento = anoNacimiento;
        this.salario = salario;
    }
    
    public static boolean esValido(int anoNacimiento){
        int anoActual = Year.now().getValue();
        return (anoNacimiento > 1900 && anoNacimiento <= anoActual);
    }
    
    public int calcularEdad(){
        int anoActual = Year.now().getValue();
        return(anoActual - this.anoNacimiento);
    }
    
    public int getAnoNacimiento(){
        return anoNacimiento;
    }
    
    public int getSalario(){
        return salario;
    }
}
