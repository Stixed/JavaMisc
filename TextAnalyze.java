public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
    abstract class KeywordAnalyzer {
        abstract String[] getKeywords();
        abstract int getLabel();
    }
    class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords;
        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords.clone();
        }
    }
    
    class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    
    }
    
    public class TooLongTextAnalyzer implements TextAnalyzer {
    
    }
}




