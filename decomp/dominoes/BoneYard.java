/*    */ package dominoes;
/*    */ 
/*    */ public class BoneYard
/*    */ {
/*    */   private Bone[] bones;
/*    */   private int numBones;
/*    */ 
/*    */   public BoneYard(int paramInt)
/*    */   {
/* 31 */     this.bones = new Bone[(paramInt + 2) * (paramInt + 1) / 2];
/*    */ 
/* 33 */     int i = 0;
/* 34 */     for (int j = 0; j <= paramInt; j++) {
/* 35 */       for (int k = j; k <= paramInt; i++) {
/* 36 */         this.bones[i] = new Bone(j, k);
/*    */ 
/* 35 */         k++;
/*    */       }
/*    */     }
/*    */ 
/* 39 */     this.numBones = this.bones.length;
/*    */   }
/*    */ 
/*    */   public Bone draw()
/*    */   {
/* 50 */     if (this.numBones > 0) {
/* 51 */       int i = (int)(Math.random() * this.numBones--);
/* 52 */       Bone localBone = this.bones[i];
/* 53 */       this.bones[i] = this.bones[this.numBones];
/* 54 */       this.bones[this.numBones] = null;
/* 55 */       return localBone;
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   public int size()
/*    */   {
/* 66 */     return this.numBones;
/*    */   }
/*    */ }

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.BoneYard
 * JD-Core Version:    0.6.2
 */