public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    
}  
enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}
abstract class KeywordAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
    
    public processText() {
    
    }
}
class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
    }
    
    @Override
    public String[] getKeywords() {
        return this.keywords;
    }
    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
}
    
class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords =  {":(" ,"=(" ,":|"};
    
    @Override
    public String[] getKeywords() {
        return this.keywords;
    }
    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
    
public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
        
    public TooLongTextAnalyzer(maxLength) {
        this.maxLength = maxLength;
    }
    public Label processText() {
    }
}


