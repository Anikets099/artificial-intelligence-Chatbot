import java.util.HashMap;

public class KnowledgeBase {

    private HashMap<String, String> data;

    public KnowledgeBase() {
        data = new HashMap<>();
        train();
    }

    private void train() {
        data.put("hello", "Hello! How can I help you?");
        data.put("hi", "Hi there!");
        data.put("your name", "I am a Java NLP Chatbot.");
        data.put("java", "Java is an object-oriented programming language.");
        data.put("course", "This is an Artificial Intelligence project.");
        data.put("bye", "Goodbye! Have a great day!");
    }

    public String findAnswer(String input) {
        for (String key : data.keySet()) {
            if (input.contains(key)) {
                return data.get(key);
            }
        }
        return null;
    }
}