/*     */ package dominoes;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Table
/*     */ {
/*  20 */   Vector _layout = new Vector();
/*     */ 
/*     */   public void play(Play paramPlay)
/*     */     throws InvalidPlayException
/*     */   {
/*     */     Bone localBone;
/*  32 */     switch (paramPlay.end())
/*     */     {
/*     */     case 0:
/*  35 */       localBone = paramPlay.bone();
/*     */ 
/*  37 */       if (localBone.right() != left()) {
/*  38 */         localBone.flip();
/*  39 */         if (localBone.right() != left()) {
/*  40 */           throw new InvalidPlayException("Bone can't be played.");
/*     */         }
/*     */       }
/*  43 */       this._layout.insertElementAt(localBone, 0);
/*     */ 
/*  45 */       return;
/*     */     case 1:
/*  49 */       localBone = paramPlay.bone();
/*     */ 
/*  51 */       if (localBone.left() != right()) {
/*  52 */         localBone.flip();
/*  53 */         if (localBone.left() != right()) {
/*  54 */           throw new InvalidPlayException("Bone can't be played.");
/*     */         }
/*     */       }
/*     */ 
/*  58 */       this._layout.addElement(localBone);
/*     */ 
/*  60 */       return;
/*     */     case 2:
/*  63 */       this._layout.addElement(paramPlay.bone());
/*     */ 
/*  65 */       return;
/*     */     }
/*     */ 
/*  68 */     throw new InvalidPlayException("Invalid table end.");
/*     */   }
/*     */ 
/*     */   public int left()
/*     */   {
/*  78 */     return ((Bone)this._layout.firstElement()).left();
/*     */   }
/*     */ 
/*     */   public int right()
/*     */   {
/*  87 */     return ((Bone)this._layout.lastElement()).right();
/*     */   }
/*     */ 
/*     */   public Bone[] layout()
/*     */   {
/*  97 */     Bone[] arrayOfBone = new Bone[this._layout.size()];
/*     */ 
/*  99 */     for (int i = 0; i < arrayOfBone.length; i++) {
/* 100 */       arrayOfBone[i] = ((Bone)this._layout.elementAt(i));
/*     */     }
/* 102 */     return arrayOfBone;
/*     */   }
/*     */ }

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.Table
 * JD-Core Version:    0.6.2
 */