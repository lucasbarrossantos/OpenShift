package view;

import dao.AlunoDao;
import model.Aluno;
import org.primefaces.context.RequestContext;
import util.FacesMessages;

import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "index")
@SessionScoped
public class IndexView {

    private Aluno aluno;
    private Aluno alunoSelecionado;
    private List<Aluno> alunos;
    private String mensagem;

    private FacesMessages messages;

    private AlunoDao dao;

    private List<String> list;
    private MethodExpression novoItem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void consultar() {
        dao = new AlunoDao();
        alunos = dao.listarTodos();
    }

    public IndexView() {
        alunos = new ArrayList<Aluno>();
        aluno = new Aluno();
        mensagem = "Projeto jsf - PrimeFaces com Open Shift - Usando Banco mysql";
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void salvar(){
        dao = new AlunoDao();
        dao.adicionar(aluno);
        messages = new FacesMessages();
        messages.info("Aluno Salvo");
        consultar();

        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:itensTable", "frm:msgs")
        );
        aluno = new Aluno();
    }

    public void remover(){
        dao = new AlunoDao();
        dao.remover(alunoSelecionado);
        alunoSelecionado = null;

        consultar();

        messages = new FacesMessages();
        messages.info("Aluno removido");
        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:itensTable", "frm:msgs")
        );
    }

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }
}
