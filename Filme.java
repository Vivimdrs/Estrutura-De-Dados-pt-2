import java.util.Objects;

public class Filme implements Filme_IF {
    private int id;
    private String nome;
    private int nota;
    private int ano;

    public Filme(int id, String nome, int nota, int ano) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Filme filme = (Filme) obj;

        return id == filme.id &&
                nota == filme.nota &&
                ano == filme.ano &&
                nome.equals(filme.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nota, ano);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }

    @Override
    public long getID() {
        return id;
    }

    @Override
    public void setID(long ID) {
        this.id = (int) ID;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF outro_filme) {
        return Integer.compare(this.id, (int) outro_filme.getID());
    }
}
