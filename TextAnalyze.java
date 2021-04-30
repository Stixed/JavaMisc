public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    Label label = Label.OK;
    for (TextAnalyzer analyzer : analyzers) {
        label = analyzer.processText(text);
        if (label != Label.OK) { return label; }
    }
    return label;
}  
//enum Label {
//        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
//}
abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
    
    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) { return getLabel(); }
            
        }
        return Label.OK;
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
        
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }
    
    public Label processText(String text) {
        if (text.length() > this.maxLength) {return Label.TOO_LONG; }
        else { return Label.OK; }
    }
}
