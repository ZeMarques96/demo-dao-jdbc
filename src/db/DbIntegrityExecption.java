package db;

public class DbIntegrityExecption extends RuntimeException {

    public DbIntegrityExecption(String msg){
        super(msg);
    }
}
