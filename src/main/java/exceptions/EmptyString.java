package exceptions;

public class EmptyString  extends RuntimeException{

    public EmptyString(){
        super();
    }

    public EmptyString(String text){
        super(text);
    }

}
