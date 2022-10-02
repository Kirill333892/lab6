package act;

import java.io.Serializable;

public class Reply implements Serializable {

    private static final long serialVersionUID = 211103L;

    private String message;
    private String[] answer;

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
