/*    */ package dominoes;
/*    */ 
/*    */ public class Play
/*    */ {
/*    */   public static final int LEFT = 0;
/*    */   public static final int RIGHT = 1;
/*    */   static final int START = 2;
/*    */   private Bone _bone;
/*    */   private int _end;
/*    */ 
/*    */   public Play(Bone paramBone, int paramInt)
/*    */   {
/* 35 */     this._bone = paramBone;
/* 36 */     this._end = paramInt;
/*    */   }
/*    */ 
/*    */   public Bone bone()
/*    */   {
/* 45 */     return this._bone;
/*    */   }
/*    */ 
/*    */   public int end()
/*    */   {
/* 54 */     return this._end;
/*    */   }
/*    */ }

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.Play
 * JD-Core Version:    0.6.2
 */