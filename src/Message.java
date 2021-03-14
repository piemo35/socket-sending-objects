import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = -5399605122490343339L;

    private final Integer A;
    private final Integer B;
    private Integer Result;

    public Message(Integer firstNumber, Integer secondNumber ){
        this.A = firstNumber;
        this.B = secondNumber;
    }

    public Integer getA() {
        return A;
    }

    public Integer getB() {
        return B;
    }

    public void setResult(Integer X)  {
        Result = X;
    }

    @Override
    public String toString() {
        return "Message{" +
                "A=" + A +
                ", B=" + B +
                ", Result=" + Result +
                '}';
    }
}