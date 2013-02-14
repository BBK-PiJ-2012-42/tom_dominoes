/*     */ package dominoes;
/*     */ 
/*     */ import dominoes.players.DominoPlayer;
/*     */ 
/*     */ public class Dominoes
/*     */ {
/*     */   private DominoPlayer[] players;
/*     */   private int maxPips;
/*     */   private DominoUI ui;
/*     */   private Table table;
/*     */   private BoneYard boneyard;
/*     */   private int pointGoal;
/*     */ 
/*     */   public Dominoes(DominoUI paramDominoUI, DominoPlayer paramDominoPlayer1, DominoPlayer paramDominoPlayer2, int paramInt1, int paramInt2)
/*     */   {
/*  61 */     this.players = new DominoPlayer[2];
/*  62 */     this.players[0] = paramDominoPlayer1;
/*  63 */     this.players[1] = paramDominoPlayer2;
/*  64 */     this.pointGoal = paramInt1;
/*  65 */     this.maxPips = paramInt2;
/*  66 */     this.ui = paramDominoUI;
/*     */   }
/*     */ 
/*     */   public DominoPlayer play()
/*     */   {
/*  79 */     boolean[] arrayOfBoolean = new boolean[this.players.length];
/*     */ 
/*  83 */     newRound();
/*     */ 
/*  85 */     for (int j = 0; j < arrayOfBoolean.length; j++) {
/*  86 */       arrayOfBoolean[j] = true;
/*     */     }
/*  88 */     int i = (int)(Math.random() * this.players.length);
/*     */     while (true)
/*     */     {
/*  92 */       for (int k = i; k < this.players.length; k++) {
/*  93 */         i = 0;
/*  94 */         arrayOfBoolean[k] = takeTurn(this.players[k]);
/*  95 */         if (this.players[k].numInHand() == 0)
/*     */         {
/*  97 */           m = 0;
/*  98 */           for (n = 0; n < this.players.length; n++) {
/*  99 */             m += weight(this.players[n]);
/*     */           }
/* 101 */           this.players[k].setPoints(this.players[k].getPoints() + m);
/* 102 */           if (this.players[k].getPoints() >= this.pointGoal) {
/* 103 */             return this.players[k];
/*     */           }
/* 105 */           this.ui.displayRoundWinner(this.players[k]);
/* 106 */           break;
/*     */         }
/*     */ 
/* 112 */         int m = 0;
/* 113 */         for (int n = 0; n < arrayOfBoolean.length; n++) {
/* 114 */           m |= arrayOfBoolean[n];
/*     */         }
/* 116 */         if (m == 0)
/*     */         {
/* 118 */           int i1 = computeWinner();
/* 119 */           if (i1 < 0) {
/* 120 */             this.ui.displayRoundWinner(null);
/* 121 */             break;
/*     */           }
/*     */ 
/* 124 */           int i2 = 0;
/* 125 */           for (int i3 = 0; i3 < this.players.length; i3++) {
/* 126 */             if (i3 != i1)
/* 127 */               i2 += weight(this.players[i3]);
/*     */           }
/* 129 */           this.players[i1].setPoints(this.players[i1].getPoints() + 
/* 130 */             i2);
/*     */ 
/* 132 */           if (this.players[i1].getPoints() >= this.pointGoal) {
/* 133 */             return this.players[i1];
/*     */           }
/* 135 */           this.ui.displayRoundWinner(this.players[i1]);
/* 136 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void newRound()
/*     */   {
/* 149 */     this.table = new Table();
/* 150 */     this.boneyard = new BoneYard(this.maxPips);
/*     */ 
/* 152 */     for (int i = 0; i < this.players.length; i++) {
/* 153 */       this.players[i].newRound();
/*     */ 
/* 155 */       for (int j = 0; j < 7; j++)
/* 156 */         this.players[i].draw(this.boneyard);
/*     */     }
/*     */     try
/*     */     {
/* 160 */       this.table.play(new Play(this.boneyard.draw(), 2));
/*     */     }
/*     */     catch (InvalidPlayException localInvalidPlayException)
/*     */     {
/*     */     }
/*     */ 
/* 164 */     this.ui.display(this.players, this.table, this.boneyard);
/*     */   }
/*     */ 
/*     */   private boolean takeTurn(DominoPlayer paramDominoPlayer)
/*     */   {
/* 174 */     Play localPlay = null;
/*     */ 
/* 177 */     while (localPlay == null) {
/*     */       try {
/* 179 */         this.table.play(localPlay = paramDominoPlayer.makePlay(this.table));
/* 180 */         this.ui.display(this.players, this.table, this.boneyard);
/*     */       } catch (CantPlayException localCantPlayException) {
/* 182 */         localPlay = null;
/* 183 */         if (this.boneyard.size() > 0) {
/* 184 */           paramDominoPlayer.draw(this.boneyard);
/* 185 */           this.ui.display(this.players, this.table, this.boneyard);
/*     */ 
/* 183 */           continue;
/*     */         }
/*     */ 
/* 188 */         return false;
/*     */       }
/*     */       catch (InvalidPlayException localInvalidPlayException) {
/* 191 */         this.ui.displayInvalidPlay(paramDominoPlayer);
/* 192 */         if (localPlay != null)
/* 193 */           paramDominoPlayer.takeBack(localPlay.bone());
/* 194 */         localPlay = null;
/*     */       }
/*     */     }
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */   private int weight(DominoPlayer paramDominoPlayer)
/*     */   {
/* 207 */     Bone[] arrayOfBone = paramDominoPlayer.bonesInHand();
/* 208 */     int i = 0;
/*     */ 
/* 210 */     for (int j = 0; (arrayOfBone != null) && (j < arrayOfBone.length); j++) {
/* 211 */       i += arrayOfBone[j].weight();
/*     */     }
/* 213 */     return i;
/*     */   }
/*     */ 
/*     */   private int computeWinner()
/*     */   {
/* 222 */     int i = 1000000;
/* 223 */     int j = 0;
/*     */ 
/* 225 */     for (int k = 0; k < this.players.length; k++) {
/* 226 */       if (weight(this.players[k]) < i) {
/* 227 */         i = weight(this.players[k]);
/* 228 */         j = k;
/* 229 */       } else if (weight(this.players[k]) == i) {
/* 230 */         j = -1;
/*     */       }
/*     */     }
/* 233 */     return j;
/*     */   }
/*     */ }

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.Dominoes
 * JD-Core Version:    0.6.2
 */