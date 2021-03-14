package br.com.nelioalves.cursomc;

import br.com.nelioalves.cursomc.domain.Categoria;
import br.com.nelioalves.cursomc.domain.Cidade;
import br.com.nelioalves.cursomc.domain.Estado;
import br.com.nelioalves.cursomc.domain.Produto;
import br.com.nelioalves.cursomc.repositories.CategoriaRepository;
import br.com.nelioalves.cursomc.repositories.CidadeRepository;
import br.com.nelioalves.cursomc.repositories.EstadoRepository;
import br.com.nelioalves.cursomc.repositories.ProdutoRepository;
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


    }
}
