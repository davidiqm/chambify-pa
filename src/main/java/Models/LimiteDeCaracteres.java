package Models;

import javax.swing.text.*;
public class LimiteDeCaracteres extends PlainDocument {
   private int limit;
   public LimiteDeCaracteres(int limit) {
      super();
      this.limit = limit;
   }
   public LimiteDeCaracteres(int limit, boolean upper) {
      super();
      this.limit = limit;
   }
   @Override
   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
      if (str == null)
         return;
      if ((getLength() + str.length()) <= limit) {
         super.insertString(offset, str, attr);
      }
   }
}