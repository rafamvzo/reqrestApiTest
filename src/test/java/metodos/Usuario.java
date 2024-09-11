package metodos;

public class Usuario {
    private String name;
    private String job;

    // Construtor
    public Usuario(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
