package br.com.alura.tdd.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

//     private BonusService service;
//     @BeforeEach
//     public void iniciar(){
//         this.service = new BonusService();
//     }
//     @Test
//     // bonus não pode ser maior que 1000
//     void bonusDeveriaSerZeroParaSalarioAlto() {
//         try{
//             service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//         } catch (Exception e) {
//         }
//     }
//     @Test
//     void bonusDeveSer10porcentoSalario() {
//         BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("5000")));
//         assertEquals(new BigDecimal("500.00"), bonus);
//     }    
//     @Test
//     void bonusDeveSer1000() {
//         BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
//         assertEquals(new BigDecimal("1000.00"), bonus);
//     }
// }

    private BonusService service;
    private Funcionario funcionario;

    @BeforeEach
    public void iniciar(){
        this.service = new BonusService();
        this.funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("0"));
    }

    @Test
    void bonusDeveSerZeroParaSalarioAlto() {
        assertThrows(Exception.class, () -> {
            funcionario.setSalario(new BigDecimal("25000"));
            service.calcularBonus(funcionario);
        });
    }

    @Test
    void bonusDeveSer10PorcentoSalario() {
        funcionario.setSalario(new BigDecimal("5000"));
        BigDecimal bonus = service.calcularBonus(funcionario);
        assertEquals(new BigDecimal("500.00"), bonus);
    }

    @Test
    void bonusDeveSer1000() {
        funcionario.setSalario(new BigDecimal("10000"));
        BigDecimal bonus = service.calcularBonus(funcionario);
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}