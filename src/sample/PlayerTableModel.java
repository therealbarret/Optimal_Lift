package sample;

public class PlayerTableModel
{
    String PlayerID, PlayerName, PlayerGender, PlayerWeight;

    public PlayerTableModel(String PlayerID, String PlayerName, String PlayerGender, String PlayerWeight)
    {
        this.PlayerID = PlayerID;
        this.PlayerName = PlayerName;
        this.PlayerGender = PlayerGender;
        this.PlayerWeight = PlayerWeight;
    }

    public String getPlayerID(){
        return PlayerID;
    }
    public void setPlayerID(String playerID) {
        PlayerID = playerID;
    }

    public String getPlayerName(){
        return PlayerName;
    }
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public String getPlayerGender() {
        return PlayerGender;
    }
    public void setPlayerGender(String playerGender) {
        PlayerGender = playerGender;
    }

    public String getPlayerWeight(){
        return PlayerWeight;
    }
    public void setPlayerWeight(String playerWeight) {
        PlayerWeight = playerWeight;
    }
}

