public class NLPProcessor {

    public String preprocess(String input) {

        input = input.toLowerCase();
        input = input.replaceAll("[^a-zA-Z0-9 ]", "");

        String[] stopWords = {"is", "the", "a", "an", "are", "what"};
        for (String word : stopWords) {
            input = input.replace(" " + word + " ", " ");
        }

        return input.trim();
    }
}