package ru.rsreu.datalayer.data;


public class Worker {
    private int idWorker;
    private Post post;
    private String FIO;

    public Worker(int idWorker, Post post, String FIO) {
        this.idWorker = idWorker;
        this.post = post;
        this.FIO = FIO;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;

    }

    @Override
    public String toString() {
        return "Worker{" +
                "idWorker=" + idWorker +
                ", post=" + post +
                ", FIO='" + FIO + '\'' +
                '}';
    }
}
