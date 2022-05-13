package toy.toy_03_slaythespire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import toy.toy_03_slaythespire.card.Card;
import toy.toy_03_slaythespire.card.attack.Strike;
import toy.toy_03_slaythespire.card.defense.Defend;
import toy.toy_03_slaythespire.unit.Hero;
import toy.toy_03_slaythespire.unit.Monster;
import toy.toy_03_slaythespire.unit.Unit;

public class Game {
	private Hero hero;
	private List<Monster> monsters;
	public List<Card> deck;
	private List<Card> hand;
	private List<Card> grave;
	private final int DRAW_NUM = 5;	// �����Ͽ� ������ �̴� ī�� ����

	/**
	 * �Ļ���
	 * @param hero
	 * @param monster
	 */
	public Game(Hero hero) {
		this.hero = hero;
		this.monsters = new ArrayList<Monster>();
		
		this.deck = new ArrayList<Card>();
		this.hand = new ArrayList<Card>();
		this.grave = new ArrayList<Card>();
		
		initAttackDeck(deck);
		initDenfenseDeck(deck);
		initMonster();
		shuffle();
	}
	
	/**
	 * ���� Ÿ�� ī�� 5���� ����
	 * @param deck
	 */
	private void initAttackDeck(List<Card> deck) {
		for(int i = 0; i < 5; i++) {
			deck.add(new Strike());
		}
	}
	
	/**
	 * ���� ���� ī�� 4���� ����
	 * @param deck
	 */
	private void initDenfenseDeck(List<Card> deck) {
		for(int i = 0; i < 4; i++) {
			deck.add(new Defend());
		}
	}

	/**
	 * ���͸� �ʱ�ȭ
	 */
	private void initMonster() {
		Monster monster = new Monster("slim", 25, 10);
		monsters.add(monster);
	}
	
	/**
	 * ���� ����
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * ������ ī�带 ����
	 */
	private void draw() {
		for(int i = 0; i < DRAW_NUM; i++) {
			if(deck.isEmpty()) {
				moveFromGraveToDeck();
			}
			hand.add(deck.remove(0));
		}
	}
	
	/**
	 * �������� �ִ� ī����� ������ �̵�
	 */
	private void moveFromGraveToDeck() {
		while(!grave.isEmpty()) {
			deck.add(grave.remove(0));
		}
	}
	
	/**
	 * ���п� �ִ� ī����� ���������� �̵�
	 */
	private void discard() {
		while(!hand.isEmpty()) {
			grave.add(hand.remove(0));
		}
	}
	
	/**
	 * ���п� �ִ� ī�� ������ ���
	 */
	private void showHand() {
		for(int i = 0; i < hand.size(); i++) {
			System.out.printf("%d : %s\n", i, hand.get(i));
		}
	}

	/**
	 * ĳ���� ������ ���
	 */
	private void showHero() {
		System.out.println("ĳ���� ����");
		System.out.println(hero);
	}
	
	/**
	 * ���� �������� ���
	 */
	private void showMonster() {
		System.out.println("���� ����");
		for(int i = 0; i < monsters.size(); i++) {
			System.out.printf("%d : %s\n", i, monsters.get(i));
		}
	}
	
	/**
	 * ī�带 ����
	 */
	private Card choiceCard() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		System.out.printf("ī�� ���� : ");
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		}
		return hand.get(n);
	}

	/**
	 * ���͸� ������
	 * @return ������ ����
	 */
	private Monster choiceTarget() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		System.out.printf("���� ���� : ");
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		}
		return monsters.get(n);
	}
	
	/**
	 * ���͸� ������� ī�带 ���
	 * @param card_num
	 * @param monster_num
	 */
	private void choice(Card card, Unit unit) {
		card.use(unit);
	}
	
	/**
	 * ������ �׾����� �˻�
	 * @param target
	 * @return
	 */
	private boolean isDie(Unit target) {
		return target.hitPoint <= 0 ? true : false;
	}
	
	/**
	 * ���� ����
	 */
	public void play() {
		
		System.out.println("���ӽ���");
		
		while(hero.hitPoint > 0 && monsters.size() > 0) {
			// ������ ī�带 ����
			draw();
			
			// ĳ���� ���� ���
			showHero();
			
			// ���� ���� ���
			showHand();
			
			// ���� ���� ���
			showMonster();
			
			// ī�� ����
			Card card = choiceCard();
			
			if(card.getKind().equals("defends")) {
				choice(card, hero);			
			}else {
				// ���� ����
				Monster monster = choiceTarget();
				
				// ����
				choice(card, monster);
				
				if(isDie(monster)) {
					System.out.println("���Ͱ� �׾����ϴ�. �¸�!");
					break;
				}
			}

			// ���� ������
			for(int i = 0; i < monsters.size(); i++) {
				Monster m = monsters.get(i);
				m.attack(hero);
				System.out.printf("%s attack you %d damage\n", m.name, m.damage);
			}
			
			// ���п� �ִ� ī�带 ������ ����
			discard();
		}
	}
}
