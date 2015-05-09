/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskGame
* Author: Steven Tardo
* Date: 12/10/14
**/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class RiskGame implements Serializable {
	// Instance variables
	private Dice dice;
	private Continent northAmerica, southAmerica, africa, europe, asia, australia;
	private Territory alaska, northwestTerritory, greenland, alberta, ontario;
	private Territory quebec, westernUS, easternUS, centralAmerica, venezuela;
	private Territory brazil, argentina, iceland, greatBritain, westernEurope;
	private Territory scandinavia, northernEurope, southernEurope, ukraine, northAfrica;
	private Territory egypt, congo, eastAfrica, southAfrica, madagascar, ural;
	private Territory afghanistan, middleEast, siberia, china, india, siam;
	private Territory japan, mongolia, irkutsk, kamchatka, yatutsk, indonesia;
	private Territory newGuinea, westernAustralia, easternAustralia, newZealand;
	private GameBoard gameboard;
	private RiskCardDeck deck;
	private Player player1, player2, player3, player4, player5, player6;
	private RiskCardHand hand1, hand2, hand3, hand4, hand5, hand6;
	private RiskCard card1, card2, card3, card4, card5, card6, card7;
	private RiskCard card8, card9, card10, card11, card12, card13, card14;
	private RiskCard card15, card16, card17, card18, card19, card20, card21;
	private RiskCard card22, card23, card24, card25, card26, card27, card28;
	private RiskCard card29, card30, card31, card32, card33, card34, card35;
	private RiskCard card36, card37, card38, card39, card40, card41, card42;
	private RiskCard card43, card44;
	HashMap<String, Territory> territoriesList;
	HashMap<String, Continent> continentsList;
	private String name;
	private int numberOfPlayers;
	ArrayList<Player> playerCollection = new ArrayList<Player>();
	
	/**
	* This constructor sets up the RiskGame name class
	*
	* String name, name of the RiskGame instance
	**/
	public RiskGame(String name) {
		this.name = name;
		alaska = new Territory("Alaska");
		northwestTerritory = new Territory("Northwest Territory");
		greenland = new Territory("Greenland");
		alberta = new Territory("Alberta");
		ontario = new Territory("Ontario");
		quebec = new Territory("Quebec");
		westernUS = new Territory("Western United States");
		easternUS = new Territory("Eastern United States");
		centralAmerica = new Territory("Central America");
		venezuela = new Territory("Venezuela");
		brazil = new Territory("Brazil");
		argentina = new Territory("Argentina");
		iceland = new Territory("Iceland");
		greatBritain = new Territory("Great Britain");
		westernEurope = new Territory("Western Europe");
		scandinavia = new Territory("Scandinavia");
		northernEurope = new Territory("Northern Europe");
		southernEurope = new Territory("Southern Europe");
		ukraine = new Territory("Ukraine");
		northAfrica = new Territory("North Africa");
		egypt = new Territory("Egypt");
		congo = new Territory("Congo");
		eastAfrica = new Territory("East Africa");
		southAfrica = new Territory("South Africa");
		madagascar = new Territory("Madagascar");
		ural = new Territory("Ural");
		afghanistan = new Territory("Afghanistan");
		middleEast = new Territory("Middle East");
		siberia = new Territory("Siberia");
		china = new Territory("China");
		india = new Territory("India");
		siam = new Territory("Siam");
		japan = new Territory("Japan");
		mongolia = new Territory("Mongolia");
		irkutsk = new Territory("Irkutsk");
		kamchatka = new Territory("Kamchatka");
		yatutsk = new Territory("Yatutsk");
		indonesia = new Territory("Indonesia");
		newGuinea = new Territory("New Guinea");
		westernAustralia = new Territory("Western Australia");
		easternAustralia = new Territory("Eastern Australia");
		newZealand = new Territory("New Zealand");
		ArrayList<Territory> northAmericaTerritories = new ArrayList<Territory>();
		ArrayList<Territory> southAmericaTerritories = new ArrayList<Territory>();
		ArrayList<Territory> africaTerritories = new ArrayList<Territory>();
		ArrayList<Territory> europeTerritories = new ArrayList<Territory>();
		ArrayList<Territory> asiaTerritories = new ArrayList<Territory>();
		ArrayList<Territory> australiaTerritories = new ArrayList<Territory>();
		northAmericaTerritories.add(alaska);
		northAmericaTerritories.add(northwestTerritory);
		northAmericaTerritories.add(greenland);
		northAmericaTerritories.add(alberta);
		northAmericaTerritories.add(ontario);
		northAmericaTerritories.add(quebec);
		northAmericaTerritories.add(westernUS);
		northAmericaTerritories.add(easternUS);
		northAmericaTerritories.add(centralAmerica);
		southAmericaTerritories.add(venezuela);
		southAmericaTerritories.add(brazil);
		southAmericaTerritories.add(argentina);
		africaTerritories.add(northAfrica);
		africaTerritories.add(egypt);
		africaTerritories.add(congo);
		africaTerritories.add(eastAfrica);
		africaTerritories.add(southAfrica);
		africaTerritories.add(madagascar);
		europeTerritories.add(iceland);
		europeTerritories.add(scandinavia);
		europeTerritories.add(greatBritain);
		europeTerritories.add(northernEurope);
		europeTerritories.add(ukraine);
		europeTerritories.add(southernEurope);
		europeTerritories.add(westernEurope);
		asiaTerritories.add(ural);
		asiaTerritories.add(afghanistan);
		asiaTerritories.add(middleEast);
		asiaTerritories.add(india);
		asiaTerritories.add(china);
		asiaTerritories.add(siberia);
		asiaTerritories.add(siam);
		asiaTerritories.add(mongolia);
		asiaTerritories.add(japan);
		asiaTerritories.add(irkutsk);
		asiaTerritories.add(yatutsk);
		asiaTerritories.add(kamchatka);
		australiaTerritories.add(indonesia);
		australiaTerritories.add(newGuinea);
		australiaTerritories.add(westernAustralia);
		australiaTerritories.add(easternAustralia);
		australiaTerritories.add(newZealand);
		northAmerica = new Continent("North America", northAmericaTerritories);
		southAmerica = new Continent("South America", southAmericaTerritories);
		africa = new Continent("Africa", africaTerritories);
		europe = new Continent("Europe", europeTerritories);
		asia = new Continent("Asia", asiaTerritories);
		australia = new Continent("Australia", australiaTerritories);
		territoriesList = new HashMap<String, Territory>();
		continentsList = new HashMap<String, Continent>();
		continentsList.put("North America", northAmerica);
		continentsList.put("South America", southAmerica);
		continentsList.put("Africa", africa);
		continentsList.put("Europe", europe);
		continentsList.put("Asia", asia);
		continentsList.put("Australia", australia);
		territoriesList.put("Alaska", alaska);
		territoriesList.put("Northwest Territory", northwestTerritory);
		territoriesList.put("Greenland", greenland);
		territoriesList.put("Alberta", alberta);
		territoriesList.put("Ontario", ontario);
		territoriesList.put("Quebec", quebec);
		territoriesList.put("Western United States", westernUS);
		territoriesList.put("Eastern United States", easternUS);
		territoriesList.put("Central America", centralAmerica);
		territoriesList.put("Venezuela", venezuela);
		territoriesList.put("Brazil", brazil);
		territoriesList.put("Argentina", argentina);
		territoriesList.put("North Africa", northAfrica);
		territoriesList.put("Egypt", egypt);
		territoriesList.put("Congo", congo);
		territoriesList.put("East Africa", eastAfrica);
		territoriesList.put("South Africa", southAfrica);
		territoriesList.put("Madagascar", madagascar);
		territoriesList.put("Iceland", iceland);
		territoriesList.put("Scandinavia", scandinavia);
		territoriesList.put("Great Britain", greatBritain);
		territoriesList.put("Northern Europe", northernEurope);
		territoriesList.put("Ukraine", ukraine);
		territoriesList.put("Southern Europe", southernEurope);
		territoriesList.put("Western Europe", westernEurope);
		territoriesList.put("Ural", ural);
		territoriesList.put("Afghanistan", afghanistan);
		territoriesList.put("Middle East", middleEast);
		territoriesList.put("India", india);
		territoriesList.put("China", china);
		territoriesList.put("Siberia", siberia);
		territoriesList.put("Siam", siam);
		territoriesList.put("Mongolia", mongolia);
		territoriesList.put("Japan", japan);
		territoriesList.put("Irkutsk", irkutsk);
		territoriesList.put("Yatutsk", yatutsk);
		territoriesList.put("Kamchatka", kamchatka);
		territoriesList.put("Indonesia", indonesia);
		territoriesList.put("New Guinea", newGuinea);
		territoriesList.put("Western Australia", westernAustralia);
		territoriesList.put("Eastern Australia", easternAustralia);
		territoriesList.put("New Zealand", newZealand);
		gameboard = new GameBoard(territoriesList, continentsList);
		dice = new Dice();
		card1 = new RiskCard("Infantry", alaska);
		card2 = new RiskCard("Cavalry", northwestTerritory);
		card3 = new RiskCard("Artillery", greenland);
		card4 = new RiskCard("Infantry", alberta);
		card5 = new RiskCard("Cavalry", ontario);
		card6 = new RiskCard("Artillery", quebec);
		card7 = new RiskCard("Infantry", westernUS);
		card8 = new RiskCard("Cavalry", easternUS);
		card9 = new RiskCard("Artillery", centralAmerica);
		card10 = new RiskCard("Infantry", venezuela);
		card11 = new RiskCard("Cavalry", brazil);
		card12 = new RiskCard("Artillery", argentina);
		card13 = new RiskCard("Infantry", northAfrica);
		card14 = new RiskCard("Cavalry", egypt);
		card15 = new RiskCard("Infantry", eastAfrica);
		card16 = new RiskCard("Cavalry", southAfrica);
		card17 = new RiskCard("Artillery", madagascar);
		card18 = new RiskCard("Infantry", iceland);
		card19 = new RiskCard("Cavalry", scandinavia);
		card20 = new RiskCard("Artillery", greatBritain);
		card21 = new RiskCard("Infantry", northernEurope);
		card22 = new RiskCard("Cavalry", ukraine);
		card23 = new RiskCard("Artillery", westernEurope);
		card24 = new RiskCard("Infantry", ural);
		card25 = new RiskCard("Cavalry", afghanistan);
		card26 = new RiskCard("Artillery", middleEast);
		card27 = new RiskCard("Infantry", india);
		card28 = new RiskCard("Cavalry", china);
		card29 = new RiskCard("Artillery", siberia);
		card30 = new RiskCard("Infantry", siam);
		card31 = new RiskCard("Cavalry", mongolia);
		card32 = new RiskCard("Artillery", japan);
		card33 = new RiskCard("Infantry", irkutsk);
		card34 = new RiskCard("Cavalry", yatutsk);
		card35 = new RiskCard("Artillery", kamchatka);
		card36 = new RiskCard("Infantry", indonesia);
		card37 = new RiskCard("Cavalry", newGuinea);
		card38 = new RiskCard("Artillery", westernAustralia);
		card39 = new RiskCard("Infantry", easternAustralia);
		card40 = new RiskCard("Cavalry", newZealand);
		card41 = new RiskCard("Artillery", congo);
		card42 = new RiskCard("Infantry", southernEurope);
		card43 = new RiskCard("*", westernUS);
		card44 = new RiskCard("*", easternUS);
		ArrayList<RiskCard> riskCardDeck = new ArrayList<RiskCard>();
		riskCardDeck.add(card1);
		riskCardDeck.add(card2);
		riskCardDeck.add(card3);
		riskCardDeck.add(card4);
		riskCardDeck.add(card5);
		riskCardDeck.add(card6);
		riskCardDeck.add(card7);
		riskCardDeck.add(card8);
		riskCardDeck.add(card9);
		riskCardDeck.add(card10);
		riskCardDeck.add(card11);
		riskCardDeck.add(card12);
		riskCardDeck.add(card13);
		riskCardDeck.add(card14);
		riskCardDeck.add(card15);
		riskCardDeck.add(card16);
		riskCardDeck.add(card17);
		riskCardDeck.add(card18);
		riskCardDeck.add(card19);
		riskCardDeck.add(card20);
		riskCardDeck.add(card21);
		riskCardDeck.add(card22);
		riskCardDeck.add(card23);
		riskCardDeck.add(card24);
		riskCardDeck.add(card25);
		riskCardDeck.add(card26);
		riskCardDeck.add(card27);
		riskCardDeck.add(card28);
		riskCardDeck.add(card29);
		riskCardDeck.add(card30);
		riskCardDeck.add(card31);
		riskCardDeck.add(card32);
		riskCardDeck.add(card33);
		riskCardDeck.add(card34);
		riskCardDeck.add(card35);
		riskCardDeck.add(card36);
		riskCardDeck.add(card37);
		riskCardDeck.add(card38);
		riskCardDeck.add(card39);
		riskCardDeck.add(card40);
		riskCardDeck.add(card41);
		riskCardDeck.add(card42);
		riskCardDeck.add(card43);
		riskCardDeck.add(card44);
		deck = new RiskCardDeck(riskCardDeck);
		deck.shuffle();
		hand1 = new RiskCardHand();
		hand2 = new RiskCardHand();
		hand3 = new RiskCardHand();
		hand4 = new RiskCardHand();
		hand5 = new RiskCardHand();
		hand6 = new RiskCardHand();
		player1 = new Player(hand1);
		player2 = new Player(hand2);
		player3 = new Player(hand3);
		player4 = new Player(hand4);
		player5 = new Player(hand5);
		player6 = new Player(hand6);
	}
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
	public void setPlayer1Name(String player1Name) {
		player1.addName(player1Name);
	}
	public void setPlayer2Name(String player2Name) {
		player2.addName(player2Name);
	}
	public void setPlayer3Name(String player3Name) {
		player3.addName(player3Name);
	}
	public void setPlayer4Name(String player4Name) {
		player4.addName(player4Name);
	}
	public void setPlayer5Name(String player5Name) {
		player5.addName(player5Name);
	}
	public void setPlayer6Name(String player6Name) {
		player6.addName(player6Name);
	}
	
	public String getPlayer1Name() {
		return player1.getName();
	}
	public String getPlayer2Name() {
		return player2.getName();
	}
	public String getPlayer3Name() {
		return player3.getName();
	}
	public String getPlayer4Name() {
		return player4.getName();
	}
	public String getPlayer5Name() {
		return player5.getName();
	}
	public String getPlayer6Name() {
		return player6.getName();
	}
	
	public void giveArmies() {
		if (numberOfPlayers == 3) {
			player1.addArmies(35);
			player2.addArmies(35);
			player3.addArmies(35);
		}
		else if (numberOfPlayers == 4) {
			player1.addArmies(30);
			player2.addArmies(30);
			player3.addArmies(30);
			player4.addArmies(30);
		}
		else if (numberOfPlayers == 5) {
			player1.addArmies(25);
			player2.addArmies(25);
			player3.addArmies(25);
			player4.addArmies(25);
			player5.addArmies(25);
		}
		else if (numberOfPlayers == 6) {
			player1.addArmies(20);
			player2.addArmies(20);
			player3.addArmies(20);
			player4.addArmies(20);
			player5.addArmies(20);
			player6.addArmies(20);
		}
	}
	
	public String getTerritoryName(int i) {
		ArrayList<Territory> territories = gameboard.getTerritoriesList();
		Territory temp = territories.get(i);
		return temp.getName();
	}
	
	/**
	* This method returns the name of the Game
	*
	* return String this.name, name of the RiskGame instance
	**/
	public String getName() {
		return this.name;
	}
}