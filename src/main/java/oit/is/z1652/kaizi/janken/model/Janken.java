package oit.is.z1652.kaizi.janken.model;

public class Janken {
  String cpuHand;
  String playerHand;
  String result;

  public Janken(String hand) {
    this.cpuHand = "Pa";
    this.playerHand = hand;
    if (cpuHand.equals("Pa")) {
      if (playerHand.equals("Pa")) {
        result = "あいこ";
      } else if (playerHand.equals("Gu")) {
        result = "CPU Win!";
      } else {
        result = "You Win!";
      }
    } else if (cpuHand.equals("Gu")) {
      if (playerHand.equals("Pa")) {
        result = "You Win!";
      } else if (playerHand.equals("Gu")) {
        result = "あいこ";
      } else {
        result = "CPU Win!";
      }
    } else {
      if (playerHand.equals("Pa")) {
        result = "CPU Win!";
      } else if (playerHand.equals("Gu")) {
        result = "You Win!";
      } else {
        result = "あいこ";
      }
    }
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public void setCpuHand(String cpuHand) {
    this.cpuHand = cpuHand;
  }

  public String getPlayerHand() {
    return playerHand;
  }

  public void setPlayerHand(String playerHand) {
    this.playerHand = playerHand;
  }
}
