/*    */ package dominoes;
/*    */ 
/*    */ public class CubbyHole
/*    */ {
/*    */   private Object data;
/*    */ 
/*    */   public synchronized Object get()
/*    */   {
/* 24 */     while (this.data == null)
/*    */       try {
/* 26 */         wait();
/*    */       }
/*    */       catch (InterruptedException localInterruptedException) {
/*    */       }
/* 30 */     Object localObject = this.data;
/* 31 */     this.data = null;
/* 32 */     return localObject;
/*    */   }
/*    */ 
/*    */   public synchronized void put(Object paramObject)
/*    */   {
/* 42 */     this.data = paramObject;
/* 43 */     notifyAll();
/*    */   }
/*    */ }

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.CubbyHole
 * JD-Core Version:    0.6.2
 */