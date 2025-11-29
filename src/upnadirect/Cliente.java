package upnadirect;

public class Cliente {
    private final int anoNacimiento;
    private final int salario;
    
    public Cliente(int anoNacimiento, int salario){
        this.anoNacimiento = anoNacimiento;
        this.salario = salario;
    }
    
    public static boolean esValido(int anoNacimiento){
        return (anoNacimiento > 1900 && anoNacimiento <= 2025);
    }
    
    public int calcularEdad(){
        return(2025 - this.anoNacimiento);
    }
    
    public int getAnoNacimiento(){
        return anoNacimiento;
    }
    
    public int getSalario(){
        return salario;
    }
}
