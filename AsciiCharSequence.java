public class AsciiCharSequence implements java.lang.CharSequence {
    private byte[] byteSequence;
    
    public AsciiCharSequence(byte[] byteSequence) {
        this.byteSequence = byteSequence.clone();
    }
    
    @Override
    public String toString() {
        return new String(this.byteSequence);
    }
    
    @Override
    public int length() {
        return this.byteSequence.length;
    }
    
    @Override
    public char charAt(int i) {
        return (char)this.byteSequence[i];
    }
    
    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] temp = new byte[end-start];
        for (int i=start;i<end;i++) {
            temp[i-start] = this.byteSequence[i];
        }
        return new AsciiCharSequence(temp);
    }
    // implementation
}
