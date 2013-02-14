package dominoes;

import dominoes.players.DominoPlayer;

public interface DominoUI
{
  public abstract void display(DominoPlayer[] paramArrayOfDominoPlayer, Table paramTable, BoneYard paramBoneYard);

  public abstract void displayRoundWinner(DominoPlayer paramDominoPlayer);

  public abstract void displayInvalidPlay(DominoPlayer paramDominoPlayer);
}

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.DominoUI
 * JD-Core Version:    0.6.2
 */