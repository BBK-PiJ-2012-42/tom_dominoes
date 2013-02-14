package dominoes.players;

import dominoes.Bone;
import dominoes.BoneYard;
import dominoes.CantPlayException;
import dominoes.Play;
import dominoes.Table;

public interface DominoPlayer
{
  public abstract Play makePlay(Table paramTable)
    throws CantPlayException;

  public abstract void takeBack(Bone paramBone);

  public abstract void draw(BoneYard paramBoneYard);

  public abstract int numInHand();

  public abstract Bone[] bonesInHand();

  public abstract void newRound();

  public abstract void setPoints(int paramInt);

  public abstract int getPoints();

  public abstract void setName(String paramString);

  public abstract String getName();
}

/* Location:           C:\Users\tom\Desktop\dominoes\
 * Qualified Name:     dominoes.players.DominoPlayer
 * JD-Core Version:    0.6.2
 */