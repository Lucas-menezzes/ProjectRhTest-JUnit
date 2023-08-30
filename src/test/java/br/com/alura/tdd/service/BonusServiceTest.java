package br.com.alura.tdd.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

    @Test
    // bonus não pode ser maior que 1000
    void bonusDeveriaSerZeroParaSalarioAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
        assertEquals(new BigDecimal("0.00"), bonus);
    }
    @Test
    void bonusDeveSer10porcentoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("5000")));
        assertEquals(new BigDecimal("500.00"), bonus);
    }    
    @Test
    void bonusDeveSer1000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}