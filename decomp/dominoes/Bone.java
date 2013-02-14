/*    */ package dominoes;
/*    */ 
/*    */ public class Bone
/*    */ {
/*    */   private int _left;
/*    */   private int _right;
/*    */ 
/*    */   public Bone(int paramInt1, int paramInt2)
/*    */   {
/* 17 */     this._left = Math.max(paramInt1, paramInt2);
/* 18 */     this._right = Math.min(paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   public int left()
/*    */   {
/* 27 */     return this._left;
/*    */   }
/*    */ 
/*    */   public int right()
/*    */   {
/* 36 */     return this._right;
/*    */   }
/*    */ 
/*    */   public int weight()
/*    */   {
/* 46 */     return this._left + this._right;
/*    */   }
/*    */ 
/*    */   public boolean equals(Bone paramBone)
/*    */   {
/* 57 */     return (Math.max(this._left, this._right) == Math.max(paramBone._left, paramBone._right)) && 
/* 57 */       (Math.min(this._left, this._right) == Math.min(paramBone._left, paramBone._right));
/*    */   }
/*    */ 
/*    */   public void flip()
/*    */   {
/* 64 */     int i = this._left;
/* 65 */     this._left = this._right;
/* 66 */     this._right = i;
/*    */   }
/*    */ }

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.Bone
 * JD-Core Version:    0.6.2
 */