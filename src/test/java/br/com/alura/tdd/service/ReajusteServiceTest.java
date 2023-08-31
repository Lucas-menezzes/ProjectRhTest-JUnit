package br.com.alura.tdd.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForBaixo() {
        inicializar();
        service.reajuste(funcionario, Desempenho.Baixo);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario()); 
    }
    @Test
    void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom() {
        service.reajuste(funcionario, Desempenho.Bom);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    void reajusteDeveriaSerDe20PorcentoQuandoDesempenhoForOtimo() {
        service.reajuste(funcionario, Desempenho.Otimo);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
