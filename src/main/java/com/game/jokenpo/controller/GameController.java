package com.game.jokenpo.controller;

public class GameController {
    public final String[] MOVE = {"pedra", "papel", "tesoura"};

    private int totalOfWins;
    private int totalOfLost;
    private int totalOfDraws;
    private int totalOfPlays;
    private int availableMoves;
    private int quantityOfMoves;
    private int gameMode;
    private int numberOfPlayerWins = 0;
    private int numberOfCpuWins = 0;
    private int numberOfDraws = 0;
    private boolean freeMode;
    private double percentageOfWins;
    private double percentageOfLost;
    private double percentageOfDraws;
    private String winnerOfGame;
    private String winnerOfPlay;
    private boolean isEndGame;

    public GameController(int gameMode){
        this.gameMode = gameMode;
        setGameMode(gameMode);
    }

    public String getCpuRandomMove(){
        int index = (int)(Math.random()* MOVE.length);

        return MOVE[index];
    }
    
    public void executePlay(String myPlay, String cpuPlay){
        if(myPlay.equals("pedra") && cpuPlay.equals("pedra")){
            winnerOfPlay = "Empate!";
            numberOfDraws++;
        }
        if(myPlay.equals("pedra") && cpuPlay.equals("papel")){
            winnerOfPlay = "Você perdeu!";
            numberOfCpuWins++;
        }
        if(myPlay.equals("pedra") && cpuPlay.equals("tesoura")){
            winnerOfPlay = "Você ganhou!";
            numberOfPlayerWins++;
        }
        if(myPlay.equals("papel") && cpuPlay.equals("papel")){
            winnerOfPlay = "Empate!";
            numberOfDraws++;
        }
        if(myPlay.equals("papel") && cpuPlay.equals("tesoura")){
            winnerOfPlay = "Você perdeu!";
            numberOfCpuWins++;
        }
        if(myPlay.equals("papel") && cpuPlay.equals("pedra")){
            winnerOfPlay = "Você ganhou!";
            numberOfPlayerWins++;
        }
        if(myPlay.equals("tesoura") && cpuPlay.equals("tesoura")){
            winnerOfPlay = "Empate!";
            numberOfDraws++;
        }
        if(myPlay.equals("tesoura") && cpuPlay.equals("pedra")){
            winnerOfPlay = "Você perdeu!";
            numberOfCpuWins++;
        }
        if(myPlay.equals("tesoura") && cpuPlay.equals("papel")){
            winnerOfPlay = "Você ganhou!";
            numberOfPlayerWins++;
        }
        isEndGame = checkEndGame();

        totalOfDraws = numberOfDraws;
        totalOfWins = numberOfPlayerWins;
        totalOfLost = numberOfCpuWins;

        if(isEndGame){
            defineWinnerOfGame();
        }
        generateStatistics();
    }

    public void setGameMode(int gameMode){
        if(gameMode == 0){
            freeMode = true;
            quantityOfMoves = 0;
        }
        else if(gameMode == 1){
            freeMode = false;
            availableMoves = 3;
            quantityOfMoves = 0;
        }
        else if(gameMode == 2){
            freeMode = false;
            availableMoves = 5;
            quantityOfMoves = 0;
        }
        else if(gameMode == 3){
            freeMode = false;
            availableMoves = 7;
            quantityOfMoves = 0;
        };
    }

    public boolean checkEndGame(){
        if(freeMode || availableMoves > 0){
            quantityOfMoves++;
        }
        if(!freeMode){
            availableMoves--;
        }
        if(!freeMode && availableMoves == 0){
            return true;
        }
        return false;
    }

    public void defineWinnerOfGame(){
        if(totalOfDraws >= totalOfWins || totalOfDraws >= totalOfLost){
            winnerOfGame = "Ihhh, o jogo empatou!";
            return;
        }
        if(totalOfWins > totalOfLost){
            winnerOfGame = "Parabéns, você é o vencedor do jogo!";
            return;
        }
        if(totalOfLost > totalOfWins){
            winnerOfGame = "Que pena, não foi dessa vez. Você perdeu o jogo!";
            return;
        }
    }

    public void generateStatistics(){
        totalOfPlays = totalOfWins + totalOfLost + totalOfDraws;

        percentageOfWins = ((double) totalOfWins / totalOfPlays) * 100;
        percentageOfLost = ((double) totalOfLost / totalOfPlays) * 100;
        percentageOfDraws = ((double) totalOfDraws / totalOfPlays) * 100;
    }

    public boolean isEndGame() {
        return isEndGame;
    }

    public int getTotalOfWins() {
        return totalOfWins;
    }

    public int getTotalOfLost() {
        return totalOfLost;
    }

    public int getTotalOfDraws() {
        return totalOfDraws;
    }

    public String getWinnerOfPlay() {
        return winnerOfPlay;
    }

    public String getWinnerOfGame() {
        return winnerOfGame;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public int getNumberOfCpuWins() {
        return numberOfCpuWins;
    }

    public int getNumberOfPlayerWins() {
        return numberOfPlayerWins;
    }

    public int getQuantityOfMoves() {
        return quantityOfMoves;
    }

    public int getTotalOfPlays() {
        return totalOfPlays;
    }

    public double getPercentageOfWins() {
        return percentageOfWins;
    }

    public double getPercentageOfLost() {
        return percentageOfLost;
    }

    public double getPercentageOfDraws() {
        return percentageOfDraws;
    }
}