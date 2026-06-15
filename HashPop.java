// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Stack;

public class HashPop {
   public HashPop() {
   }

   static String build(String var0) {
      Stack var1 = new Stack();

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         char var3 = var0.charAt(var2);
         if (var3 == '#') {
            if (!var1.isEmpty()) {
               var1.pop();
            }
         } else {
            var1.push(var3);
         }
      }

      StringBuilder var4 = new StringBuilder();

      while(!var1.isEmpty()) {
         var4.append(var1.pop());
      }

      return var4.reverse().toString();
   }

   public static void main(String[] var0) {
      String var1 = "abc#d##c";
      String var2 = build(var1);
      System.out.println(var2);
   }
}
