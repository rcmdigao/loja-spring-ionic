package br.com.nelioalves.cursomc;

import br.com.nelioalves.cursomc.domain.*;
import br.com.nelioalves.cursomc.domain.enums.TipoCliente;
import br.com.nelioalves.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;



    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria();
        c1.setId(null);
        c1.setNome("Informatica");

        Categoria c2 = new Categoria();
        c2.setId(null);
        c2.setNome("Escritorio");

        Produto prod1 = new Produto();
        prod1.setId(null);
        prod1.setNome("Computador");
        prod1.setPreco(2000.00);

        Produto prod2 = new Produto();
        prod2.setId(null);
        prod2.setNome("Impressora");
        prod2.setPreco(800.00);

        Produto prod3 = new Produto();
        prod3.setId(null);
        prod3.setNome("Mouse");
        prod3.setPreco(80.00);

        c1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        c2.getProdutos().addAll(Arrays.asList(prod2));

        prod1.getCategorias().addAll(Arrays.asList(c1));
        prod2.getCategorias().addAll(Arrays.asList(c1, c2));
        prod3.getCategorias().addAll(Arrays.asList(c1));

        categoriaRepository.saveAll(Arrays.asList(c1, c2));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

        /*********************************************************/

        Estado est1 = new Estado();
        est1.setId(null);
        est1.setNome("Minas Gerais");

        Estado est2 = new Estado();
        est2.setId(null);
        est2.setNome("São Paulo");

        Cidade cid1 = new Cidade();
        cid1.setId(null);
        cid1.setEstado(est1);
        cid1.setNome("Uberlandia");

        Cidade cid2 = new Cidade();
        cid2.setId(null);
        cid2.setEstado(est2);
        cid2.setNome("Campinas");

        Cidade cid3 = new Cidade();
        cid3.setId(null);
        cid3.setEstado(est2);
        cid3.setNome("Bauru");

        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        /*********************************************************/

        Cliente cli1 = new Cliente();
        cli1.setId(null);
        cli1.setNome("Marina Matos");
        cli1.setEmail("ninamatos@gmail.com");
        cli1.setCpfOuCnpj("92985768282");
        cli1.setTipo(TipoCliente.PESSOAFISICA.getCod());
        cli1.getTelefones().addAll(Arrays.asList("33022013", "94948504"));

        Endereco end1 = new Endereco();
        end1.setId(null);
        end1.setLogradouro("Recanto dos Nobres");
        end1.setNumero("18");
        end1.setComplemento("Conjunto B");
        end1.setBairro("Sobradinho");
        end1.setCidade(cid1);
        end1.setCliente(cli1);

        Endereco end2 = new Endereco();
        end2.setId(null);
        end2.setLogradouro("Imperio dos Nobres");
        end2.setNumero("22");
        end2.setComplemento("Conjunto E");
        end2.setBairro("Sobradinho");
        end2.setCidade(cid1);
        end2.setCliente(cli1);

        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));

    }
}
