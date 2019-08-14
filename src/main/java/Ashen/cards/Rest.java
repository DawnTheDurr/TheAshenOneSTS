package Ashen.cards;

import Ashen.patch.CardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Rest extends CustomCard {
  public static final String ID = "Ashen:Rest";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final int COST = 0;
	public static final String IMG = "images/cards/skills/defend.png";
	private static final int HEAL = 999;
	private static final int ENEMY_HEAL = 999;
  
  public Rest() {
    super(ID, NAME, IMG, COST, DESCRIPTION, AbstractCard.CardType.SKILL, CardEnum.THE_ASHEN_ONE_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
		this.tags.add(AbstractCard.CardTags.HEALING);
		this.baseMagicNumber = 6;
    this.magicNumber = this.baseMagicNumber;
  }

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new HealAction(p, p, this.magicNumber));
		AbstractDungeon.actionManager.addToBottom(new HealAction(m, m, this.magicNumber));
  }

	@Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(4);
      upgradeDamage(8);
    } 
  }

	@Override
  public AbstractCard makeCopy() { 
		return new Rest(); 
	}


}
