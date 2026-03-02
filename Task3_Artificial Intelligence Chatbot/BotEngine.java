import java.time.LocalDate;
import java.time.LocalTime;

public class BotEngine {

    private NLPProcessor nlp;
    private KnowledgeBase kb;

    public BotEngine() {
        nlp = new NLPProcessor();
        kb = new KnowledgeBase();
    }

    public String getResponse(String userInput) {

        String processed = nlp.preprocess(userInput);

        String answer = kb.findAnswer(processed);

        if (answer != null) {
            return answer;
        }

        if (processed.contains("time")) {
            return "Current time: " + LocalTime.now().toString();
        }

        if (processed.contains("date")) {
            return "Today's date: " + LocalDate.now().toString();
        }

        return "Sorry, I don't understand your question.";
    }
}