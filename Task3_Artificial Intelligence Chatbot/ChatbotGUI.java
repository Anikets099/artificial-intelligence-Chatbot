import javax.swing.*;
import java.awt.*;

public class ChatbotGUI {

    private JTextArea chatArea;
    private JTextField inputField;
    private BotEngine engine;

    public ChatbotGUI() {

        engine = new BotEngine();

        JFrame frame = new JFrame("AI NLP Chatbot");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());

        frame.setVisible(true);
    }

    private void sendMessage() {
        String userText = inputField.getText();
        chatArea.append("You: " + userText + "\n");

        String response = engine.getResponse(userText);

        chatArea.append("Bot: " + response + "\n\n");
        inputField.setText("");
    }
}