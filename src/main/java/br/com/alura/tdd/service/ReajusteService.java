package br.com.alura.tdd.service;
import java.math.BigDecimal;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

// public class ReajusteService {
//     public void reajuste(Funcionario funcionario, Desempenho desempenho) {
//         if (desempenho == Desempenho.Baixo){
//             BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.03"));
//             funcionario.reajustarSalario(aumento);
//         }
//         else if (desempenho == Desempenho.Bom){
//             BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.15"));
//             funcionario.reajustarSalario(aumento);
//         }
//         else if (desempenho == Desempenho.Otimo){
//             BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.20"));
//             funcionario.reajustarSalario(aumento);
//         }
//     }
// }

//REFACTOR
public class ReajusteService {

    public void reajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal aumento = funcionario.getSalario().multiply(desempenho.percentualReajuste());
        // BigDecimal percentual = desempenho.percentualReajuste();
        // BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(aumento);
    }
}