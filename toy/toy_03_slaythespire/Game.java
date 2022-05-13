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
	private final int DRAW_NUM = 5;	// 영웅턴에 덱에서 뽑는 카드 개수

	/**
	 * 셍상지
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
	 * 덱에 타격 카드 5장을 넣음
	 * @param deck
	 */
	private void initAttackDeck(List<Card> deck) {
		for(int i = 0; i < 5; i++) {
			deck.add(new Strike());
		}
	}
	
	/**
	 * 덱에 수비 카드 4장을 넣음
	 * @param deck
	 */
	private void initDenfenseDeck(List<Card> deck) {
		for(int i = 0; i < 4; i++) {
			deck.add(new Defend());
		}
	}

	/**
	 * 몬스터를 초기화
	 */
	private void initMonster() {
		Monster monster = new Monster("slim", 25, 10);
		monsters.add(monster);
	}
	
	/**
	 * 덱을 섞음
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * 덱에서 카드를 뽑음
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
	 * 묘지덱에 있는 카드들을 덱으로 이동
	 */
	private void moveFromGraveToDeck() {
		while(!grave.isEmpty()) {
			deck.add(grave.remove(0));
		}
	}
	
	/**
	 * 손패에 있는 카드들을 묘지덱으로 이동
	 */
	private void discard() {
		while(!hand.isEmpty()) {
			grave.add(hand.remove(0));
		}
	}
	
	/**
	 * 손패에 있는 카드 정보를 출력
	 */
	private void showHand() {
		for(int i = 0; i < hand.size(); i++) {
			System.out.printf("%d : %s\n", i, hand.get(i));
		}
	}

	/**
	 * 캐릭터 정보를 출력
	 */
	private void showHero() {
		System.out.println("캐릭터 정보");
		System.out.println(hero);
	}
	
	/**
	 * 몬스터 정보들을 출력
	 */
	private void showMonster() {
		System.out.println("몬스터 정보");
		for(int i = 0; i < monsters.size(); i++) {
			System.out.printf("%d : %s\n", i, monsters.get(i));
		}
	}
	
	/**
	 * 카드를 선택
	 */
	private Card choiceCard() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		System.out.printf("카드 선택 : ");
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("입력이 잘못되었습니다.");
		}
		return hand.get(n);
	}

	/**
	 * 몬스터를 선택함
	 * @return 선택한 몬스터
	 */
	private Monster choiceTarget() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		System.out.printf("몬스터 선택 : ");
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("입력이 잘못되었습니다.");
		}
		return monsters.get(n);
	}
	
	/**
	 * 몬스터를 대상으로 카드를 사용
	 * @param card_num
	 * @param monster_num
	 */
	private void choice(Card card, Unit unit) {
		card.use(unit);
	}
	
	/**
	 * 유닛이 죽었는지 검사
	 * @param target
	 * @return
	 */
	private boolean isDie(Unit target) {
		return target.hitPoint <= 0 ? true : false;
	}
	
	/**
	 * 게임 시작
	 */
	public void play() {
		
		System.out.println("게임시작");
		
		while(hero.hitPoint > 0 && monsters.size() > 0) {
			// 덱에서 카드를 뽑음
			draw();
			
			// 캐릭터 정보 출력
			showHero();
			
			// 손패 정보 출력
			showHand();
			
			// 몬스터 정보 출력
			showMonster();
			
			// 카드 선택
			Card card = choiceCard();
			
			if(card.getKind().equals("defends")) {
				choice(card, hero);			
			}else {
				// 몬스터 선택
				Monster monster = choiceTarget();
				
				// 수행
				choice(card, monster);
				
				if(isDie(monster)) {
					System.out.println("몬스터가 죽었습니다. 승리!");
					break;
				}
			}

			// 적이 공격함
			for(int i = 0; i < monsters.size(); i++) {
				Monster m = monsters.get(i);
				m.attack(hero);
				System.out.printf("%s attack you %d damage\n", m.name, m.damage);
			}
			
			// 손패에 있는 카드를 묘지로 버림
			discard();
		}
	}
}
