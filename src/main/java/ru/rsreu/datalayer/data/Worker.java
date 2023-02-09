package ru.rsreu.datalayer.data;

/**
 * Workers of system
 */
public class Worker {
    private int idWorker;
    private Post post;
    private String FIO;

    /**
     * constructor
     * @param idWorker
     * @param post
     * @param FIO
     */
    public Worker(int idWorker, Post post, String FIO) {
        this.idWorker = idWorker;
        this.post = post;
        this.FIO = FIO;
    }

    /**
     * id worker getter
     * @return
     */
    public int getIdWorker() {
        return idWorker;
    }

    /**
     * id worker setter
     * @param idWorker
     */
    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    /**
     * post getter
     * @return
     */
    public Post getPost() {
        return post;
    }

    /**
     * post setter
     * @param post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * FIO getter
     * @return
     */
    public String getFIO() {
        return FIO;
    }

    /**
     * tostring
     * @return
     */
    @Override
    public String toString() {
        return "Worker{" +
                "idWorker=" + idWorker +
                ", post=" + post +
                ", FIO='" + FIO + '\'' +
                '}';
    }
}
